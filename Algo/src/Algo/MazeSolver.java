/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algo;

/**
 *
 * @author N A G Y
 */
public class MazeSolver {
	private final char[][] result;
	private final Position srt_pos;
	private final Position end_pos;
	private final int[][] maze;
	
	public MazeSolver(int[][] maze, Position srt_pos, Position end_pos) {
		this.maze = maze;
		this.srt_pos = srt_pos;
		this.end_pos = end_pos;
		result = new char[maze.length][maze[0].length];
	}

	public char[][] getResult() {
		return result;
	}
        
	public char Solver()
	{
		for(int i=0; i<maze.length; i++){
			for(int j=0; j<maze[i].length; j++){
                            if(maze[i][j] == 1)
					result[i][j] = '*'; 
                            if(maze[i][j] == 0)
					result[i][j] = '.';  
        }}
		char Done = path_finder(maze, srt_pos);
	
		result[srt_pos.getY()][srt_pos.getX()] = 'C';
		result[end_pos.getY()][end_pos.getX()] = 'E';
		
		return Done;
	}
	static int count = 1;
	private char path_finder(int[][] maze, Position pos)
	{
                if(pos.getY() == end_pos.getY() && pos.getX() == end_pos.getX()){
		    System.out.println("E ]");
                    return 'X';
                }
		else
		{
                        if(pos.getY() == srt_pos.getY() && pos.getX() == srt_pos.getX()){
                            System.out.print("[ C -> ");}
                
                        char c = 0;
                        result[pos.getY()][pos.getX()] = 'X';
                        
                        int offset = pos.getY() - 1;
			if(offset < 0) offset = maze.length - 1;
			
			char north = result[offset][pos.getX()];
                        if(north == '.'){
			if(north == '.')
			{
                                System.out.print("North -> ");
                                count=count+1;
				c = path_finder(maze, new Position(offset, pos.getX()));
				result[offset][pos.getX()] = c;
				if(c == 'X') 
                                    return 'X';
			}
                        
                       	offset = pos.getX() + 1;
			if(offset >= maze[0].length) offset = 0;
			
			char east = result[pos.getY()][offset];
			if(east == '.')
			{
                                System.out.print("East -> ");
                                count=count+1;
				c = path_finder(maze, new Position(pos.getY() , offset));
				result[pos.getY()][offset] = c;
				if(c == 'X') 
                                    return 'X';
			}
                        }
                        offset = pos.getX() + 1;
			if(offset >= maze[0].length) offset = 0;
			
			char east = result[pos.getY()][offset];
                        if(east == '.'){
			if(east == '.')
			{
                                System.out.print("East -> ");
                                count=count+1;
				c = path_finder(maze, new Position(pos.getY() , offset));
				result[pos.getY()][offset] = c;
				if(c == 'X') 
                                    return 'X';
			}
			offset = pos.getY() + 1;
			if(offset >= maze.length) offset = 0;
			
			char south = result[offset][pos.getX()];
			if(south == '.')
			{
                                System.out.print("South -> ");
                                count=count+1;
				c = path_finder(maze, new Position(offset, pos.getX()));
				result[offset][pos.getX()] = c;
				if(c == 'X')
                                    return 'X';
			}
                        }
                        
			offset = pos.getY() + 1;
			if(offset >= maze.length) offset = 0;
			
			char south = result[offset][pos.getX()];
                        if(south == '.'){
			if(south == '.')
			{
                                System.out.print("South -> ");
                                count=count+1;
				c = path_finder(maze, new Position(offset, pos.getX()));
				result[offset][pos.getX()] = c;
				if(c == 'X')
                                    return 'X';
			}
                        offset = pos.getX() - 1;
			if(offset < 0) offset = maze[0].length - 1;
                        
			char west = result[pos.getY()][offset];
			if(west == '.')
			{
                                System.out.print("West -> ");
                                count=count+1;
				c = path_finder(maze, new Position(pos.getY() , offset));
				result[pos.getY()][offset] = c;
				if(c == 'X')
                                    return 'X';
			}
                        }
                        offset = pos.getX() - 1;
			if(offset < 0) offset = maze[0].length - 1;
                        
			char west = result[pos.getY()][offset];
                        if(west == '.'){
			if(west == '.')
			{
                                System.out.print("West -> ");
                                count=count+1;
				c = path_finder(maze, new Position(pos.getY() , offset));
				result[pos.getY()][offset] = c;
				if(c == 'X')
                                    return 'X';
			}
                        offset = pos.getY() - 1;
			if(offset < 0) offset = maze.length - 1;
			
			north = result[offset][pos.getX()];
			if(north == '.')
			{
                                System.out.print("North -> ");
                                count=count+1;
				c = path_finder(maze, new Position(offset, pos.getX()));
				result[offset][pos.getX()] = c;
				if(c == 'X') 
                                    return 'X';
			}
                        }
                }
            return 0;
        }

	public void PrintResult()
	{                          
                System.out.println("\n Shortest Path = " + count);
                System.out.println();
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<result[i].length; j++) {
                             System.out.print(result[i][j] + " ");
                        }
			System.out.println();
		}
		System.out.println();
	}
}