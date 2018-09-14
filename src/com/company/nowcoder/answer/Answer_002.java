package com.company.nowcoder.answer;

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Built using CHelper plug-in Actual solution is at the top
 *
 * @author palayutm
 */
public class Answer_002 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}

	static class TaskB {
		final int mod = (int) 1e9 + 7;

		int cal(int[] a, int L) {
			if (L == 0)
				return 0;
			long ret = 0;
			for (int z = 0; z < 30; z++) {
				int[] b = new int[a.length];
				int S = 0;
				int[] c1 = { 0, 0 }, c2 = { 1, 0 };
				for (int i = 1; i < a.length; i++) {
					int v = (((1 << z) & a[i]) > 0 ? 1 : 0);
					b[i] = (b[i - 1] ^ v);
					if (b[i] == 1) {
						c1[i % 2]++;
					} else {
						c2[i % 2]++;
					}
					if (b[i] == 0) {
						S += c1[i % 2];
					} else {
						S += c2[i % 2];
					}
					S %= mod;
					if (i - L >= 0) {
						if (b[i - L] == 1) {
							c1[(i - L) % 2]--;
						} else {
							c2[(i - L) % 2]--;
						}
					}
				}
				ret = (ret + (long) S * (1 << z)) % mod;
			}
			return (int) ret;
		}

		public void solve(int testNumber, InputReader in, PrintWriter out) {
			int n = in.nextInt(), L = in.nextInt(), R = in.nextInt();
			int[] a = new int[n + 1];
			for (int i = 0; i < n; i++) {
				a[i + 1] = in.nextInt();
			}
			out.println((cal(a, R) - cal(a, L - 1) + mod) % mod);
		}

	}

	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

	}
}