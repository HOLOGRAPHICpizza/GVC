package org.peak15.GVC;

import org.peak15.GVCLib.*;
import org.peak15.GVCLib.commands.*;

/**
 * GVC main program.
 */
public class GVC {
	
	public static void main(String[] args) {
		GVCLib gvclib = new GVCLib();
		
		// Register the commands we want.
		gvclib.registerCommand(new Help(gvclib));
		gvclib.registerCommand(new Init(gvclib));
		
		try {
			// Run the command specified.
			if(args.length > 0) {
				String[] newArgs = new String[args.length - 1];
				System.arraycopy(args, 1, newArgs, 0, args.length - 1);
				gvclib.runCommand(args[0], newArgs);
			}
			else {
				// Run the help command if none is specified.
				gvclib.runCommand("help", null);
			}
		}
		catch(GVCException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
