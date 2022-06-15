import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotClass extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "supusefulchatallert_bot";
    }

    @Override
    public String getBotToken() {
        return "*****";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            String command = update.getMessage().getText();
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            String out = "";
            if (command.equals("/myname")) {
                out = update.getMessage().getFrom().getFirstName();
                System.out.println(out);
                message.setText(out);
            } else if (command.equals("/mylastname")) {
                out = update.getMessage().getFrom().getLastName();
                System.out.println(out);
                message.setText(out);
            } else if (command.equals("/myfullname")) {
                out = update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName();
                System.out.println(out);
                message.setText(out);
            } else {
                out = "Who said: " + command + "?";
                System.out.println(out);
                message.setText(out);
            }

            message.setChatId(update.getMessage().getChatId().toString());

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }
}
