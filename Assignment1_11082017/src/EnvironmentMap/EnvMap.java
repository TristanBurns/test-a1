package EnvironmentMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Scanner;

public class EnvMap {
	public static int n;
	public static int[][] costArray;

	public void LoadEnvMap(String filename) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String line;

		try {
			line = input.readLine();
			n = Integer.parseInt(line);
			costArray = new int[n][n];
			int j = 0;
			for(int i=0; i < n; i++){
				line = input.readLine();
				String[] tokens = line.split(" ");
				j = 0;
				for (String token : tokens){
					costArray[i][j++] = Integer.parseInt(token); 
				}
			}
		}
		finally {
			input.close();
		}

	}


}
