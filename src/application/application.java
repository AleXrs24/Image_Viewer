package application;

import control.command;
import control.NextImageCommand;
import control.PrevImageCommand;
import ui.swing.ApplicationFrame;
import model.Image;
import persistence.ImageListLoader;
import persistence.file.FileImageListLoader;
import ui.swing.ActionListenerFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class application {

    public static void main(String[] args) {
        new application().execute();
    }
    
    private static final String PATH = "C:\\Users\\aaleXrs24\\Pictures\\Lanzarote-La Graciosa 2014";
    private Map<String, command> commandMap;
    private ApplicationFrame frame;

    private void execute() {
        ImageListLoader loader = createImageListLoader(PATH);
        List<Image> list = loader.load();
        frame = new ApplicationFrame(createActionListenerFactory());
        frame.getImageViewer().setImage(list.get(0));
        createCommands();
        frame.setVisible(true);
    }

    private void createCommands() {
        commandMap = new HashMap<>();
        commandMap.put(">", new NextImageCommand(frame.getImageViewer()));
        commandMap.put("<", new PrevImageCommand(frame.getImageViewer()));
    }

    private ImageListLoader createImageListLoader(String path) {
        return new FileImageListLoader(path);
    }

    private ActionListenerFactory createActionListenerFactory() {
        return new ActionListenerFactory() {

            @Override
            public ActionListener create(final String action) {
                return new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        command Command = commandMap.get(action);
                        if (Command == null) return;
                        Command.execute();
                    }
                };
            }
        };
    }  
}