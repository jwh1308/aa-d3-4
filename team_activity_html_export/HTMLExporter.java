package com.holub.database;

import java.io.*;
import java.util.*;

public class HTMLExporter implements Table.Exporter
{	private final Writer out;
	private 	  int	 width;

	public HTMLExporter( Writer out )
	{	this.out = out;
	}

	public void storeMetadata( String tableName,
							   int width,
							   int height,
							   Iterator columnNames ) throws IOException

	{
		out.write("<tr>");
		out.write(tableName);
		out.write("</tr>");
		storeRow(columnNames);
	}

	public void storeRow( Iterator data ) throws IOException {
		int i = width;
		out.write("<tr>");
		while (data.hasNext()) {
			out.write("<td>");
			Object datum = data.next();
			if( datum != null )	
				out.write( datum.toString() );

			out.write("</td>");
		}
		out.write("</tr>");
	}

	public void startTable() throws IOException {
		// start table tag
		out.write("<table>");
	}
	public void endTable()   throws IOException {
		// end table tag
		out.write("</table>");
	}
}
