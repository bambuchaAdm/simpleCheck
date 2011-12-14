package pl.krakow.vlo.simplechecker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Główna klasa programu
 * 
 * @author bambucha
 * 
 *         TODO Czyszczenie po testach TODO Testowanie aplikacji
 * 
 */
public class Tester
{
	private File		root;
	private File		binary;
	private Compiler	compiler;
	private TestLoader	loader;
	private ResultSaver	saver;

	public Tester(File root)
	{
		this.root = root;
	}

	private Process getProcess(File source) throws IOException
	{
		ProcessBuilder builder = new ProcessBuilder(binary.getAbsolutePath());
		return builder.start();
	}

	private void writeTest(Process task, File testcase) throws IOException
	{
		InputStream in = new FileInputStream(testcase);
		OutputStream out = task.getOutputStream();
		int buff = 0;
		while((buff = in.read()) != -1)
			out.write(buff);
	}

	public void testFile(File testCase) throws IOException
	{
		Process task = getProcess();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Brak implementacji");
	}

}
