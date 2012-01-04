package pl.krakow.vlo.simplechecker;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa kompilująca testowany program przy pomocy gcc używając -O2 -static -lm
 * 
 * @author bambucha
 * 
 * 
 */
public class Compiler
{
	private static final Logger	log	= Logger.getLogger(Compiler.class.getName());

	/**
	 * Kompluje pliki przy pomocy
	 * 
	 * @param what
	 *            plik źródłowy
	 * @return binarka
	 */
	public File compile(File root)
	{
		File output = new File(root, "out");
		File[] toCompile = root.listFiles(new FilenameFilter()
		{
			@Override
			public boolean accept(File dir, String name)
			{
				return name.endsWith(".cpp");
			}
		});
		if(toCompile.length > 1)
			throw new IllegalStateException(
					"Dwa lub więcej plików *.cpp. Jestem głupi i nie wiem co robić :(");
		File what = toCompile[0];
		try
		{
			Runtime.getRuntime().exec(
					getCompilerCommand() + " " + getCompilerFlags() + " "
							+ what.getAbsolutePath() + getOutputSwitch() + " "
							+ output.getAbsolutePath());
		}
		catch(IOException e)
		{
			log.log(Level.SEVERE, "Wyjątek", e);
		}
		throw new RuntimeException();
	}

	private String getCompilerFlags()
	{
		return "-O2 -static -lm";
	}

	protected String getCompilerCommand()
	{
		return "gcc";
	}

	protected String getOutputSwitch()
	{
		return "-o";
	}

}
