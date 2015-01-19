package control;

import userInterface.ImageViewer;

public class PrevImageCommand extends imageCommand {

    public PrevImageCommand(ImageViewer viewer) {
        super(viewer);
    }
    @Override
    public void execute() {
        this.getViewer().showPrevImage();
    }
}
