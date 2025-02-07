package org.example.command;

public class RemoveMemberCommand implements Command{
    private String emailAddress;
    private String listName;
    private EWSService receiver;

    public RemoveMemberCommand(String email, String listName, EWSService service) {
        this.emailAddress = email;
        this.listName = listName;
        this.receiver = service;
    }

    @Override
    public void execute() {
        receiver.removeMember(emailAddress,listName);
    }
}
