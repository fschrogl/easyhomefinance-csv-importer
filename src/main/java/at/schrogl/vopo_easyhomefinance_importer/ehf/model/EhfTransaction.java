package at.schrogl.vopo_easyhomefinance_importer.ehf.model;

import at.schrogl.vopo_easyhomefinance_importer.ehf.model.EhfCategoryHolder.EhfCategory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class EhfTransaction implements Serializable {

	static {
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMinimumFractionDigits(0);
		numberFormat.setMaximumFractionDigits(2);
		if (numberFormat instanceof DecimalFormat) {
			((DecimalFormat) numberFormat).setDecimalSeparatorAlwaysShown(false);
			((DecimalFormat) numberFormat).setGroupingUsed(false);
		}
		FORMATTER_AMOUNT = numberFormat;
	}

	private static final String TABLE_NAME = "EASYHOMEFINANCE";
	private static final SimpleDateFormat FORMATTER_DATE = new SimpleDateFormat("yyyy-MM-dd");
	private static final NumberFormat FORMATTER_AMOUNT;

	public final Date date;
	public final String subject;
	public final EhfCategory category;
	public final BigDecimal amount;
	public final EhfAccount sourceAccount;
	public final EhfAccount destinationAccount;

	public EhfTransaction(Date date, String subject, EhfCategory category, BigDecimal amount, EhfAccount sourceAccount, EhfAccount destinationAccount) {
		this.date = Objects.requireNonNull(date);
		this.subject = Objects.requireNonNull(subject);
		this.category = Objects.requireNonNull(category);
		this.amount = Objects.requireNonNull(amount);
		this.sourceAccount = Objects.requireNonNull(sourceAccount);
		this.destinationAccount = (destinationAccount == null) ? EhfAccount.NONE : destinationAccount;
	}

	public static String getTableSql() {
		return "CREATE TABLE " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, _date DATE, subject TEXT NOT NULL, " +
			"description TEXT, number NUMBER, groupId TEXT, inOut TEXT, account TEXT, type TEXT, number_copied TEXT, " +
			"account_to TEXT);";
	}

	public String getTransactionSql() {
		return String.format("INSERT INTO " + TABLE_NAME +
				"(_date, subject, description, groupId, inOut, account, \"type\", number_copied, account_to) VALUES " +
				"(%s, %s, %s, %s, %s, %s, 1, %s, %s)",
			FORMATTER_DATE.format(date), subject, category, category.groupId, category.inOut, sourceAccount.id, FORMATTER_AMOUNT.format(amount), destinationAccount.id);
	}
}
