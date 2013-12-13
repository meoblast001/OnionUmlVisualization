# OnionUmlVisualization User Manual
## Description of User Interface￼
#### Diagram View Window
The diagram viewing window displays all classes from the loaded UML file. User can select classes with a click and drag action from the mouse. Selected classes may be controlled from the UML Diagram Control window.
#### UML Diagram Control Window
The UML Diagram Control window is parted three ways.
1. The first window partition will hide and show classes from each package. Buttons in this region will select all or none (View All, View None) of the packages in the .classml file, as listed in the table directly below the buttons. The table also lists checkboxes next to the package names, so that the user may select or deselect individual packages. Once all selections (or deselections) have been made, the user should click Update Diagram to send the changes and update the Diagram View window.
2. The second partition is used to control Onion Compaction of loaded classes. The first two buttons on the left (Compact Selected, Expand Selected) will compact, or expand, any currently selected classes. The buttons on the right (Compact All, Expand All, Reset All) will compact all of the classes into onion notation, expand all classes out of onion notation, or return all classes to default.
3. The third partition has visibility preferences, which are also available in the preferences section. Select or deselect the checkbox next to the appropriate labels to display (or hide when deselected) class stereotypes, class fields, and class methods.

## How Should I Install the Plug-in as a User?
#### On which platforms does OnionUMLVisualization run?
OnionUMLVisualization runs on any Java platform, eg, Windows, Linux, and OS X.

#### Steps to set up OnionUMLVisualization:
1. Create a .cml file by running src2srcML on the source directory of the system (Java only) you wish to visualize. Once this is done, run srcML2classML on the output file just created. This will create the .cml file needed.
2. In order to open the project in Eclipse you will first need to install Eclipse. Download “Eclipse for RCP and RAP Developers”. Currently Eclipse Kepler (4.3) is supported.
3. Next you will need to install the “eGit” plug-in for Eclipse and the “JGraphX” library. 
4. Then you can open the project directly from the Github repository URL. It will ask you for your Github userid and password. After you open it, you should be able to run it by clicking the green arrow on the top. 

## Features
#### Searching Classes Within Visualization
To engage the search feature strike CTRL + “5”.

#### Changing Setting

To change setting of OnionUMLVisualization. 

PC:
  1.	Click on Window menu.
  2.	Scroll down and select Preferences.
  3.	Click on OnionUmlVisualization.

MAC OS X: 
  1.	Click on Eclipse menu.
  2.	Scroll down and select Preferences.
  3.	Click on OnionUmlVisualization.

#### Change Color Preferences
This preference pane allows you to select the color scheme of the diagram being visualized.

#### Change Layout Preferences
The change layout preference pane allows you to change the layout settings of the diagrams being visualized.

#### Change Visibility Preferences
The visibility preference pane allows you to choose whether to display or hide class stereotypes, fields, and methods.

