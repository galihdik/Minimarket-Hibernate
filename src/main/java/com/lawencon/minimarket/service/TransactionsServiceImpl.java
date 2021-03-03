package com.lawencon.minimarket.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.support.TransactionTemplate;

import com.lawencon.minimarket.dao.TransactionsDao;
import com.lawencon.minimarket.model.About;
import com.lawencon.minimarket.model.DetailTransactions;
import com.lawencon.minimarket.model.Items;
import com.lawencon.minimarket.model.Payments;
import com.lawencon.minimarket.model.Transactions;
import com.lawencon.minimarket.model.UserSessionCache;
import com.lawencon.minimarket.model.Users;

/**
 *
 * @author Galih Dika
 *
 */

public class TransactionsServiceImpl extends BaseService implements TransactionService {
	private TransactionsDao transactionDao;
	private DetailTransactionService detailTransactionService;
	private ItemService itemServ;
	private AboutService aboutServ;
	private PaymentService paymentServ;
	private UserSessionCache usrCache;
	private TransactionTemplate transactionTemplate;

	public TransactionsServiceImpl(TransactionsDao transactionDao, DetailTransactionService detailTransactionService,
			ItemService itemServ, UserSessionCache usrCache, AboutService aboutServ, PaymentService paymentServ,
			TransactionTemplate transactionTemplate) {
		this.transactionDao = transactionDao;
		this.detailTransactionService = detailTransactionService;
		this.itemServ = itemServ;
		this.usrCache = usrCache;
		this.aboutServ = aboutServ;
		this.paymentServ = paymentServ;
		this.transactionTemplate = transactionTemplate;
	}

	@Override
	public List<Transactions> getTransaction() throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				transactionDao.getListTransactions();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}

	@Override
	public void addData(List<DetailTransactions> trxDetail, Transactions transaction) throws Exception {
		getTransactionTemplate().execute(val -> {
			try {
				About aboutCode = aboutServ.getAboutByCode("1");
				Users activedUsr = usrCache.getActiveUser();
				transaction.setIdUsers(activedUsr);
				transaction.setIdAbout(aboutCode);
				Transactions idTransaction = transactionDao.insertData(transaction);
				BigDecimal totalHarga = BigDecimal.ZERO;

				for (DetailTransactions detailTransactions : trxDetail) {
					detailTransactions.setPrice(detailTransactions.getIdItems().getPriceItems()
							.multiply(new BigDecimal(detailTransactions.getQty())));
					detailTransactions.setIdTransaction(idTransaction);
					totalHarga = totalHarga.add(detailTransactions.getIdItems().getPriceItems()
							.multiply(new BigDecimal(detailTransactions.getQty())));
				}
				detailTransactionService.addData(trxDetail, idTransaction);
				idTransaction.setPriceTotal(totalHarga);
				transactionDao.updateData(idTransaction);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

	}

	@Override
	public Items getItem(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return itemServ.getItemByCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});

	}

	@Override
	public Payments getPayments(String code) throws Exception {
		return getTransactionTemplate().execute(val -> {
			try {
				return paymentServ.getPaymentsByCode(code);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
	}
}
