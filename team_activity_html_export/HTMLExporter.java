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

	{	this.width = width;
		out.write(tableName == null ? "<anonymous>" : tableName );
		out.write("\n");
		storeRow( columnNames ); // comma separated list of columns ids
		// write table name
		out.write("<tr>");
		out.write(tableName);
		out.write("</tr>");
		// write table header
		out.write("<tr>");
		storeRow(columnNames);
		out.write("</tr>");		
	}

	public void storeRow( Iterator data ) throws IOException {
		int i = width;
		out.write("<tr>");
		out.write("<td>");
		while (data.hasNext()) {
			Object datum = data.next();
			if( datum != null )	
				out.write( datum.toString() );

			if( --i > 0 ) {
				out.write("</td>");
				out.write("<td>");
			}
		}
		out.write("</td>");
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
