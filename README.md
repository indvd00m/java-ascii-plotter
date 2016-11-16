#ascii-plotter

Simple ascii plotter in pure java with no external dependencies.


## Using
Add repository to your POM:

	<repository>
		<id>indvd00m-github-repo</id>
		<url>https://github.com/indvd00m/maven-repo/raw/master/repository</url>
	</repository>

Add dependency to your war maven project:

	<dependency>
		<groupId>com.indvd00m.plot.ascii</groupId>
		<artifactId>ascii-plotter</artifactId>
		<version>0.1.0-SNAPSHOT</version>
	</dependency>

Create points and plot them:

	List<IPoint> points = new ArrayList<IPoint>();
	for (int degree = 0; degree <= 360; degree++) {
		double val = Math.sin(Math.toRadians(degree));
		IPoint point = new Point(degree, val);
		points.add(point);
	}
	IPlotter plotter = new Plotter();
	IPlot plot = plotter.plot(points);
	String s = plot.getString();
	System.out.println(s);

Output:

	 1,00|                  *                                                       
	     |            ************                                                  
	     |          ***           ***                                               
	     |        **                ***                                             
	 0,50|      ***                   ***                                           
	     |     **                       **                                          
	     |   **                          **                                         
	     |  **                             **                                       
	     |***                               **                                      
	 0,00|*                                  ***                                  **
	     |                                     **                               *** 
	     |                                      **                             **   
	     |                                        **                          **    
	     |                                         **                       **      
	-0,50|                                          ***                   ***       
	     |                                            ***                **         
	     |                                              ***           ***           
	     |                                                 ************             
	-1,00+--------------------------------------------------------------------------
	     0                90                 180                270              360


## Release notes

### Version 0.1.0-SNAPSHOT
- First beta version.

## Roadmap

This component is developed as a hobby with no public roadmap or any guarantees of upcoming releases. That said, the following features are planned for upcoming releases:
- ...

## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the following:
- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit
- Send a pull request for the original project
- Comment on the original issue that you have implemented a fix for it

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

ascii-plotter is written by David E. Veliev.
