package nth.playlistmanager.commandline;

import java.util.ArrayList;
import java.util.List;

import nth.introspect.ui.commandline.IntrospectApplicationForCommandLine;
import nth.playlistmanager.domain.PlaylistService;

public class PlaylistManagerCommandLine extends IntrospectApplicationForCommandLine{

	/**
	 * @param args
	 */
	public static void main(String[] arguments) {
		launch(arguments);
	}

	@Override
	public List<Class<?>> getServiceClasses() {
		List<Class<?>> initializer=new ArrayList<Class<?>>();
		initializer.add(PlaylistService.class);
		return initializer;
	}

	@Override
	public List<Class<?>> getInfrastructureClasses() {
		return new ArrayList<Class<?>>();
	}

}
