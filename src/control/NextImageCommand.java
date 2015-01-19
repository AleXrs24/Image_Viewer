package control;

import userInterface.ImageViewer;

public class NextImageCommand extends imageCommand {

    public NextImageCommand(ImageViewer viewer) {
        super(viewer);
    }
    @Override
    public void execute() {
        this.getViewer().showNextImage();
    }
}
