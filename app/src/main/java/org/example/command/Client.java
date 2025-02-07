package org.example.command;

public class Client {

	public static void main(String[] args) throws InterruptedException {
		EWSService service = new EWSService();
		
		Command addFirstMemberCommand = new AddMemberCommand("a@a.com", "spam", service);
		MailTasksRunner.getInstance().addCommand(addFirstMemberCommand);
		
		Command addSecondMemberCommand = new AddMemberCommand("b@b", "spam", service);
		MailTasksRunner.getInstance().addCommand(addSecondMemberCommand);

		Command removeFirstMemberCommand = new RemoveMemberCommand("a@a.com","spam",service);
		MailTasksRunner.getInstance().addCommand(removeFirstMemberCommand);

		Thread.sleep(3000);
		MailTasksRunner.getInstance().shutdown();
	}

}
