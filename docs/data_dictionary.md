Data Dictionary
===============

- edu.ysu.onionuml
	- Activator.java
		- mPlugin
		- PLUGIN_ID
		- getDefault()
		- getImageDescriptor(String)
		- Activator()
		- start(BundleContext)
		- stop(BundleContext)
		- compact
- edu.ysu.onionuml.compact
	- DiagramGraph.java
		- Node
		- mClassNodeMap
		- mElements
		- mRootNodes
		- addElement(ClassElementGraphicalModel)
		- addRelationship(RelationshipElementGraphicalModel, ClassElementGraphicalModel, ClassElementGraphicalModel)
		- update()
		- updateGraph()
- edu.ysu.onionuml.core
	- ClassmlWriter.java
		- XMLNS
		- write(UmlClassModel, String)
	- RelationshipType.java
		- AGGREGATION
		- ASSOCIATION
		- COMPOSITION
		- DEPENDENCY
		- DIRECTEDASSOCIATION
		- GENERALIZATION
		- HYPER_AGGREGATION
		- HYPER_ASSOCIATION
		- HYPER_COMPOSITION
		- HYPER_DEPENDENCY
		- HYPER_DIRECTEDASSOCIATION
		- HYPER_GENERALIZATION
		- HYPER_REALIZATION
		- REALIZATION
		- parseRelationshipType(String)
		- toString()
	- UmlAttribute.java
		- dataType
		- name
		- visibility
		- UmlAttribute(Visibility, String, String)
		- toString()
	- UmlClassElement.java
		- mAttributes
		- mIsAbstract
		- mName
		- mOperations
		- mStereotype
		- mVisibility
		- UmlClassElement()
		- UmlClassElement(String)
		- UmlClassElement(String, String)
		- addAttribute(UmlAttribute)
		- addOperation(UmlOperation)
		- getAttributes()
		- getIsAbstract()
		- getName()
		- getOperations()
		- getStereotype()
		- getVisibility()
		- setIsAbstract(boolean)
		- setName(String)
		- setStereotype(String)
		- setVisibility(Visibility)
		- toString()
	- UmlClassModel.java
		- fromFile(String)
		- mDescription
		- mName
		- mPackages
		- mRelationships
		- UmlClassModel(String)
		- UmlClassModel(String, String, Map<String, UmlPackageElement>, Map<String, UmlRelationshipElement>)
		- getDescription()
		- getName()
		- getPackages()
		- getRelationships()
		- readFromFile(String)
		- toFile(String)
	- UmlOperation.java
		- isAbstract
		- isStatic
		- name
		- parameters
		- returnType
		- visibility
		- UmlOperation(Visibility, String, String, boolean, boolean)
		- toString()
	- UmlOperationParameter.java
		- dataType
		- name
		- UmlOperationParameter(String, String)
		- toString()
	- UmlPackageElement.java
		- mClasses
		- mName
		- UmlPackageElement(String)
		- UmlPackageElement(String, Map<String, UmlClassElement>)
		- addClass(String, UmlClassElement)
		- getClasses()
		- getName()
		- setName(String)
	- UmlRelationshipElement.java
		- Multiplicity
		- mHeadId
		- mHeadMultiplicityMax
		- mHeadMultiplicityMin
		- mLabel
		- mTailId
		- mTailMultiplicityMax
		- mTailMultiplicityMin
		- mType
		- UmlRelationshipElement(String, String, String, RelationshipType)
		- UmlRelationshipElement(String, String, String, RelationshipType, Multiplicity, Multiplicity, Multiplicity, Multiplicity)
		- getHeadId()
		- getHeadMultiplicityMax()
		- getHeadMultiplicityMin()
		- getLabel()
		- getTailId()
		- getTailMultiplicityMax()
		- getTailMultiplicityMin()
		- getType()
		- setHeadId(String)
		- setHeadMultiplicityMax(Multiplicity)
		- setHeadMultiplicityMin(Multiplicity)
		- setLabel(String)
		- setTailId(String)
		- setTailMultiplicityMax(Multiplicity)
		- setTailMultiplicityMin(Multiplicity)
		- setType(RelationshipType)
	- UmlSaxHandler.java
		- mElementNames
		- mObjects
		- mPackages
		- mRelationships
		- mTitle
		- endElement(String, String, String)
		- getPackages()
		- getRelationships()
		- getTitle()
		- startElement(String, String, String, Attributes)
	- Visibility.java
		- PRIVATE
		- PROTECTED
		- PUBLIC
		- parseVisibility(String)
		- toString()
- edu.ysu.onionuml.ui
	- DiagramControlView.java
		- ID
		- PADDING
		- TEXT_COMPACT_ALL
		- TEXT_COMPACT_SELECTED
		- TEXT_COMPACTION_CONTROLLER
		- TEXT_EXPAND_ALL
		- TEXT_EXPAND_SELECTED
		- TEXT_NO_DIAGRAM
		- TEXT_PACKAGES_CONTROLLER
		- TEXT_RESET_ALL
		- TEXT_SELECT_ALL
		- TEXT_SELECT_NONE
		- mCompactionControlView
		- mCurrentClassDiagram
		- mDefaultView
		- mPackagesView
		- mPackageTable
		- mParentComposite
		- createCompactionController(Composite)
		- createDefaultView(Composite)
		- createPackagesController(Composite)
		- createPartControl(Composite)
		- getCurrentClassDiagram()
		- onCompactSelectedPressed()
		- onExpandSelectedPressed()
		- populatePackageTable()
		- setCurrentClassDiagram(ClassDiagramEditPart)
		- setFocus()
	- ModelViewer.java
		- ID
		- ZOOM_LEVELS
		- mEditorInput
		- mModel
		- ModelViewer()
		- configureGraphicalViewer()
		- createPartControl(Composite)
		- dispose()
		- doSave(IProgressMonitor)
		- doSaveAs()
		- getAdapter(Class)
		- init(IEditorSite, IEditorInput)
		- initializeGraphicalViewer()
		- isDirty()
		- isSaveAsAllowed()
	- ModelViewerActionBarContributor.java
		- buildActions()
		- contributeToToolBar(IToolBarManager)
		- declareGlobalActionKeys()
	- ModelViewerInput.java
		- mModelList
		- mNextId
		- mId
		- ModelViewerInput(ClassDiagramGraphicalModel)
		- dispose()
		- equals(Object)
		- exists()
		- getAdapter(Class)
		- getId()
		- getImageDescriptor()
		- getModel()
		- getName()
		- getPersistable()
		- getToolTipText()
	- PerspectiveFactory.java
		- BOTTOM_FOLDER_ID
		- BOTTOM_FOLDER_RATIO
		- PROJECT_EXPOLORER_RATIO
		- createInitialLayout(IPageLayout)
- edu.ysu.onionuml.ui.graphics
	- EditPartFactory.java
		- createEditPart(EditPart, Object)
	- IEventListener.java
		- eventOccured(String)
	- IEventRegistrar.java
		- registerEventListener(IEventListener)
		- unregisterEventListener()
- edu.ysu.onionuml.ui.graphics.editparts
	- ClassDiagramEditPart.java
		- EVENT_ACTIVATED
		- EVENT_REFRESH_REQUIRED
		- mSelectedClasses
		- activate()
		- addToSelection(ClassElementEditPart)
		- createEditPolicies()
		- createFigure()
		- deactivate()
		- eventOccured(String)
		- getDragTracker(Request)
		- getModelChildren()
		- getSelectedClasses()
		- lookupEditPartById(String)
		- removeFromSelection(ClassElementEditPart)
	- ClassElementEditPart.java
		- ABSTRACT_FONT
		- CLASS_COLOR
		- NAME_ABSTRACT_FONT
		- NAME_FONT
		- NORMAL_FONT
		- STATIC_FONT
		- STEREOTYPE_FONT
		- mDragLocation
		- activate()
		- createEditPolicies()
		- createFigure()
		- getDragTracker(Request)
		- mouseDoubleClicked(MouseEvent)
		- mouseDragged(MouseEvent)
		- mouseEntered(MouseEvent)
		- mouseExited(MouseEvent)
		- mouseHover(MouseEvent)
		- mouseMoved(MouseEvent)
		- mousePressed(MouseEvent)
		- mouseReleased(MouseEvent)
		- refreshVisuals()
	- HyperClassElementEditPart.java
		- createEditPolicies()
		- createFigure()
		- refreshVisuals()
	- RelationshipElementEditPart.java
		- LABEL_DISTANCE
		- LINE_DASH_STYLE
		- createEditPolicies()
		- createFigure()
		- getDragTracker(Request)
		- isSelectable()
		- makeHeadDecoration(RelationshipType)
		- makeMultiplicityString(Multiplicity, Multiplicity)
		- refreshVisuals()
- edu.ysu.onionuml.ui.graphics.figures
	- ClassFigure.java
		- mContentFont
		- mIsOnion
		- mNameLabel
		- mOnionRelationshipsFigure
		- mOperationsFigure
		- mPropertiesFigure
		- mStereotypeLabel
		- ClassFigure(Color, Font, Font, Font)
		- addOnionRelationship(RelationshipType)
		- addOperation(String, Image, Font)
		- addProperty(String, Image, Font)
		- clear()
		- getNameString()
		- getOperationIndex(int, int)
		- getOperationString(int)
		- getPropertyIndex(int, int)
		- getPropertyString(int)
		- getStereotypeString()
		- reconstruct()
		- setIsOnion(boolean)
		- setNameFont(Font)
		- setNameIcon(Image)
		- setNameString(String)
		- setStereotypeString(String)
	- ClassSectionFigure.java
		- SPACING
		- ClassSectionFigure(boolean)
	- OnionRelationshipFigure.java
		- BORDER_THICKNESS
		- CANVAS
		- LINE_DASH
		- mFillColor
		- mLine
		- mLinePoints
		- mPolygon
		- mRelationshipType
		- OnionRelationshipFigure(RelationshipType)
		- makeShapes(RelationshipType)
		- paint(Graphics)
		- primTranslate(int, int)
- edu.ysu.onionuml.ui.graphics.graphicalmodels
	- ClassDiagramGraphicalModel.java
		- NUM_CLASSES_FOR_HYPEREDGES
		- mClassIdMap
		- mClassModel
		- mClassSizeChanged
		- mDiagramGraph
		- mElements
		- mListener
		- mRelationshipIdMap
		- ClassDiagramGraphicalModel(UmlClassModel)
		- eventOccured(String)
		- getClassModel()
		- getElements()
		- initEdges()
		- layout()
		- layoutEdges(Map<String, ArrayList<String>>, RelationshipType)
		- lookupGraphicalModelById(String)
		- lookupIdByGraphicalModel(IElementGraphicalModel)
		- registerEventListener(IEventListener)
		- unregisterEventListener()
		- update()
	- ClassElementGraphicalModel.java
		- EVENT_SIZE_CHANGED
		- mActualHead
		- mChildRelationships
		- mClassElement
		- mIsCompacted
		- mIsHyper
		- mIsParentCompacted
		- mIsVisible
		- mListener
		- mPackageElement
		- mPosition
		- mSize
		- ClassElementGraphicalModel(UmlClassElement, UmlPackageElement)
		- getActualHead()
		- getChildRelationships()
		- getClassElement()
		- getPackageElemet()
		- getPosition()
		- getSize()
		- isCompacted()
		- isHyper()
		- isParentCompacted()
		- isVisible()
		- registerEventListener(IEventListener)
		- setChildRelationships(List<RelationshipType>)
		- setIsCompacted(boolean)
		- setIsHyper(boolean, ClassElementGraphicalModel)
		- setIsParentCompacted(boolean)
		- setIsVisible(boolean)
		- setPosition(Point)
		- setSize(Dimension)
		- unregisterEventListener()
	- IElementGraphicalModel.java
		- getPosition()
		- getSize()
		- setPosition(Point)
		- setSize(Dimension)
	- RelationshipElementGraphicalModel.java
		- mPosition
		- mRelationship
		- mSize
		- RelationshipElementGraphicalModel(UmlRelationshipElement)
		- getPosition()
		- getRelationshipElement()
		- getSize()
		- setPosition(Point)
		- setSize(Dimension)
- edu.ysu.onionuml.ui.handler
	- OpenClassModelCommandHandler.java
		- OPEN_DIALOG_TITLE
		- OPEN_FILTER_EXT
		- OPEN_FILTER_NAMES
		- addHandlerListener(IHandlerListener)
		- dispose()
		- execute(ExecutionEvent)
		- isEnabled()
		- isHandled()
		- removeHandlerListener(IHandlerListener)