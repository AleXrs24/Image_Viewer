package control;

import userInterface.ImageViewer;
public abstract class imageCommand implements command {

    private final ImageViewer viewer;

    public imageCommand(ImageViewer viewer) {
        this.viewer = viewer;
    }

    public ImageViewer getViewer() {
        return viewer;
    }
}
