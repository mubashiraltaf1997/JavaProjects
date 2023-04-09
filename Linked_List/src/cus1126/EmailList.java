package cus1126;

public class EmailList {

    private EmailMessage head;
    private EmailMessage tail;

    public void addEmail(String id, String to, String subject, String body, String date) {
        EmailMessage newEmail = new EmailMessage(id, to, subject, body, date);

        if (head == null) {
            head = newEmail;
            tail = newEmail;
        } else {
            tail.next = newEmail;
            tail = newEmail;
        }
    }

    public void displayEmails() {
        EmailMessage current = head;
        while (current != null) {
            System.out.println("Message ID: " + current.messageID);
            System.out.println("To: " + current.to);
            System.out.println("Subject: " + current.subject);
            System.out.println("Body: " + current.body);
            System.out.println("Date: " + current.date);
            System.out.println("------------------------");
            current = current.next;
        }
    }

    private class EmailMessage {

        String messageID;
        String to;
        String subject;
        String body;
        String date;
        EmailMessage next;

        public EmailMessage(String id, String to, String subject, String body, String date) {
            this.messageID = id;
            this.to = to;
            this.subject = subject;
            this.body = body;
            this.date = date;
            this.next = null;
        }
    }
}
