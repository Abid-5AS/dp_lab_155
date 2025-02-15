public class InAppNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String message) {
        System.out.println("In-App Notification: " + message);
    }
}
