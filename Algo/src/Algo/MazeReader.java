/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author N A G Y
 */
public class MazeReader {
	
	public static void main(String[] args) {
		
		Scanner location = new Scanner(System.in);
		System.out.print("Enter maze file: ");
		String filename = location.nextLine();
		location.close();
                
		System.out.println();
                
		File f = new File(filename);
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("File not found! Application terminated\n" + e.toString());
			return;
		}
		
		int width = 0, height = 0;
		Position srt_pos, end_pos;
		int[][] maze;
                
                height = sc.nextInt();
		width = sc.nextInt();
		srt_pos = new Position(sc.nextInt(), sc.nextInt());
		end_pos = new Position(sc.nextInt(), sc.nextInt());
		maze = new int[height][width];
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++)
				maze[i][j] = sc.nextInt();	
		sc.close();
		
		MazeSolver MS = new MazeSolver(maze, srt_pos, end_pos);

		char Done = MS.Solver();
		MS.PrintResult();
		
		if(Done == 'X')
                        System.out.println("Maze solved");
		else
			System.out.println("Maze can not be solved");
	}
}