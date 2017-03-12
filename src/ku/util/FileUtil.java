package ku.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Test and compare speeds with 3 copy method.
 * @author admin Pimwalun Witchawanitchanun
 *
 */
public class FileUtil {
	protected int blocksize;

	/**
	 * Copy file 1 byte at a time.
	 * @param in is the InputStream of the file to be read.
	 * @param out is the OutputStream of the file to be write.
	 */
	static void copy(InputStream in, OutputStream out) {
		try {
			byte[] buffer = new byte[1];
			int count = in.read(buffer);
			while (count != -1) {
				out.write(buffer, 0, count);
				count = in.read(buffer);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Copy a file that defines specific byte at a time.
	 * @param in is the InputStream of the file to be read.
	 * @param out is the OutputStream of the file to be write.
	 * @param blocksize is the designated byte to be copied at a time.
	 */
	static void copy(InputStream in, OutputStream out, int blocksize) {
		try {
			byte[] buffer = new byte[blocksize];
			int count = in.read(buffer);
			while (count != -1) {
				out.write(buffer, 0, count);
				count = in.read(buffer);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Copy file one line at a time using BufferedReader and PrintWriter.
	 * @param in is the InputStream of the file to be read.
	 * @param out is the OutputStream of the file to be write.
	 */
	static void bcopy(InputStream in, OutputStream out) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			PrintWriter writer = new PrintWriter(out);
			String read = reader.readLine();
			while (read != null) {
				writer.write(read);
				read = reader.readLine();
			}
			reader.close();
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
