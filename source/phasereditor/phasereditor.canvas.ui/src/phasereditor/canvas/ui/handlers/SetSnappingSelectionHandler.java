package phasereditor.canvas.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.handlers.HandlerUtil;

import phasereditor.canvas.core.EditorSettings;
import phasereditor.canvas.ui.editors.CanvasEditor;
import phasereditor.canvas.ui.shapes.ISpriteNode;

public class SetSnappingSelectionHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		CanvasEditor editor = (CanvasEditor) HandlerUtil.getActiveEditor(event);
		EditorSettings settings = editor.getCanvas().getSettingsModel();

		Object node = HandlerUtil.getCurrentStructuredSelection(event).getFirstElement();

		if (node != null && node instanceof ISpriteNode) {
			ISpriteNode obj = (ISpriteNode) node;
			settings.setStepWidth((int) obj.getControl().getTextureWidth());
			settings.setStepHeight((int) obj.getControl().getTextureHeight());
			settings.setEnableStepping(true);
			editor.getCanvas().getBackGridPane().repaint();
		}

		return null;
	}

}
