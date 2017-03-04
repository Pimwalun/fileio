package ku.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class FileUtil {
	protected int blocksize;

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
