import view.ParticipantFormView;
import controller.ParticipantController;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ParticipantFormView view = new ParticipantFormView();
            new ParticipantController(view);
            view.setVisible(true);
        });
    }
}
