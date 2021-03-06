package nth.accounts.domain.account;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.List;

import nth.accounts.domain.user.User;
import nth.introspect.generic.util.TitleBuilder;
import nth.introspect.layer5provider.reflection.behavior.executionmode.ExecutionMode;
import nth.introspect.layer5provider.reflection.behavior.executionmode.ExecutionModeType;
import nth.introspect.layer5provider.reflection.behavior.order.Order;

import com.sun.istack.internal.NotNull;

public class Account {
	private String accountName;
	private User user;
	private List<AccountAttribute> attributes;

	public Account() {
		attributes = new ArrayList<AccountAttribute>();
	}

	@NotNull
	@Order(sequenceNumber=1)
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Order(sequenceNumber=2)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Order(sequenceNumber=3)
	public List<AccountAttribute> getAttributes() {
		return attributes;
	}

	@ExecutionMode(mode = ExecutionModeType.EXECUTE_METHOD_DIRECTLY)
	public void userPutUser(User user) {
		setUser(user);
	}

	@ExecutionMode(mode = ExecutionModeType.EXECUTE_METHOD_AFTER_CONFORMATION)
	public void userClearUser() {
		setUser(null);
	}

	public void setAttributes(List<AccountAttribute> attributes) {
		this.attributes = attributes;
	}

	public void attributesAddEmailAttribute(AccountAttribute emailAttribute) {
		attributes.add(emailAttribute);
	}

	public AccountAttribute attributesAddEmailAttributeParameterFactory() {
		AccountAttribute attribute=new AccountAttribute();
		attribute.setName("E-Mail");
		return attribute;
	}

	public void attributesAddUserNameAttribute(AccountAttribute userNameAttribute) {
		attributes.add(userNameAttribute);
	}

	public AccountAttribute attributesAddUserNameAttributeParameterFactory() {
		AccountAttribute attribute=new AccountAttribute();
		attribute.setName("User name");
		return attribute;
	}
	
	public void attributesAddPasswordAttribute(AccountAttribute passwordAttribute) {
		attributes.add(passwordAttribute);
	}

	public AccountAttribute attributesAddPasswordAttributeParameterFactory() {
		AccountAttribute attribute=new AccountAttribute();
		attribute.setName("Password");
		return attribute;
	}
	
	public void attributesAddUrlAttribute(AccountAttribute urlAttribute) {
		attributes.add(urlAttribute);
	}

	public AccountAttribute attributesAddUrlAttributeParameterFactory() {
		AccountAttribute attribute=new AccountAttribute();
		attribute.setName("URL");
		return attribute;
	}


	@ExecutionMode(mode = ExecutionModeType.EDIT_PARAMETER_THEN_EXECUTE_METHOD_OR_CANCEL)
	public void attributesAddCustomAttribute(AccountAttribute newAttribute) {
		attributes.add(newAttribute);
	}

	public AccountAttribute attributesAddCustomAttributeParameterFactory() {
		return new AccountAttribute();
	}

	@ExecutionMode(mode = ExecutionModeType.EXECUTE_METHOD_AFTER_CONFORMATION)
	public void attributesRemoveAttribute(AccountAttribute attribute) {
		attributes.remove(attribute);
	}
	

	@ExecutionMode(mode = ExecutionModeType.EDIT_PARAMETER_THEN_EXECUTE_METHOD_OR_CANCEL)
	public void attributesModifyAttribute(AccountAttribute attribute) {
	}


	@ExecutionMode(mode = ExecutionModeType.EXECUTE_METHOD_DIRECTLY)
	public void attributesCopyAttributeValue(AccountAttribute attribute) {
		StringSelection selection = new StringSelection(attribute.getValue());
	    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	    clipboard.setContents(selection, selection);
	}
	
	@Override
	public String toString() {
		TitleBuilder titleBuilder = new TitleBuilder("-");
		if (user != null) {
			titleBuilder.append(user.getName());
		}
		titleBuilder.append(accountName);
		return titleBuilder.toString();
	}

}
