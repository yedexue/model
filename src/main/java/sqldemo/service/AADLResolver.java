/*
 * package sqldemo.service;
 * 
 * import java.util.ArrayList; import java.util.HashMap; import java.util.List;
 * import java.util.Map; import java.util.regex.Matcher; import
 * java.util.regex.Pattern;
 * 
 * import org.dom4j.Document; import org.dom4j.DocumentException; import
 * org.dom4j.Element; import org.dom4j.Node; import org.dom4j.io.SAXReader;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import sqldemo.dao.InvocationChannelMapper; import
 * sqldemo.dao.MessageChannelMapper; import sqldemo.dao._eventMapper; import
 * sqldemo.dao._exceptionMapper; import sqldemo.dao._partitionMapper; import
 * sqldemo.dao._provideMapper; import sqldemo.dao._requireMapper; import
 * sqldemo.dao._stateMapper; import sqldemo.dao._taskMapper; import
 * sqldemo.dao.busMapper; import sqldemo.dao.communicationchannelMapper; import
 * sqldemo.dao.componentMapper; import sqldemo.dao.componenttransitionMapper;
 * import sqldemo.dao.connectionsMapper; import sqldemo.dao.dataobjectMapper;
 * import sqldemo.dao.deviceMapper; import sqldemo.dao.linkpointMapper; import
 * sqldemo.dao.rtosMapper; import sqldemo.dao.taskscheduleMapper; import
 * sqldemo.dao.transitionMapper; import sqldemo.dao.transitionstateMapper;
 * import sqldemo.model.ASyncMessaging; import sqldemo.model.DispatchChannel;
 * import sqldemo.model.InvocationChannel; import sqldemo.model.MessageChannel;
 * import sqldemo.model._event; import sqldemo.model._exception; import
 * sqldemo.model._partition; import sqldemo.model._provide; import
 * sqldemo.model._require; import sqldemo.model._state; import
 * sqldemo.model._task; import sqldemo.model.bus; import
 * sqldemo.model.communicationchannel; import sqldemo.model.component; import
 * sqldemo.model.componenttransition; import sqldemo.model.connections; import
 * sqldemo.model.dataobject; import sqldemo.model.device; import
 * sqldemo.model.linkpoint; import sqldemo.model.rtos; import
 * sqldemo.model.shareddataaccess; import sqldemo.model.syncinterface; import
 * sqldemo.model.taskschedule; import sqldemo.model.transition; import
 * sqldemo.model.transitionstate;
 * 
 * //解析模型,本模块只负责模型文件的解析
 * 
 * @Service("AADLResolver") public class AADLResolver { // @Autowired // private
 * ModelService ms; // private ModelService ms; // 存储所有模型文件的文件夹 Map<String,
 * String> aadlFiles = new HashMap<String, String>(); static String
 * modeldirectory; static String dynamicfilename;
 * 
 * static String hardmodelfile; static String errlibfile; static String
 * compositelibfile;
 * 
 * static List<? extends Node> components = null; static List<? extends Node>
 * cchannels = null; static Map<String, component> componentlist = new
 * HashMap<String, component>(); static Map<String, component> taskcomponentlist
 * = new HashMap<String, component>(); static List<_task> tasklist = new
 * ArrayList<_task>();
 * 
 * static List<linkpoint> portlist = new ArrayList<linkpoint>(); static
 * List<_require> requirelist = new ArrayList<_require>(); static List<_provide>
 * providelist = new ArrayList<_provide>();
 * 
 * static List<_exception> exceptionlist = new ArrayList<_exception>(); static
 * List<device> devicelist = new ArrayList<device>(); static List<bus> buslist =
 * new ArrayList<bus>(); static List<rtos> rtoslist = new ArrayList<rtos>();
 * 
 * static List<shareddataaccess> sdalist = new ArrayList<shareddataaccess>();
 * static List<syncinterface> synclist = new ArrayList<syncinterface>(); static
 * List<ASyncMessaging> ASMlist = new ArrayList<ASyncMessaging>();
 * 
 * static List<communicationchannel> cclist = new
 * ArrayList<communicationchannel>(); static List<InvocationChannel> ivclist =
 * new ArrayList<InvocationChannel>(); static List<DispatchChannel> dpclist =
 * new ArrayList<DispatchChannel>(); static List<MessageChannel> mclist = new
 * ArrayList<MessageChannel>();
 * 
 * static List<_event> eventlist = new ArrayList<_event>(); static List<_state>
 * statelist = new ArrayList<_state>();
 * 
 * static List<transition> tslist = new ArrayList<transition>(); static
 * List<transitionstate> ts_slist = new ArrayList<transitionstate>();
 * 
 * static List<_partition> partitionlist = new ArrayList<_partition>(); static
 * List<taskschedule> tscList = new ArrayList<taskschedule>();
 * 
 * @Autowired private connectionsMapper cm;
 * 
 * @Autowired private taskscheduleMapper tscmapper;
 * 
 * @Autowired private componentMapper camArchMapper;
 * 
 * @Autowired private linkpointMapper portsMapper;
 * 
 * @Autowired private _provideMapper pM;
 * 
 * @Autowired private _requireMapper rm;
 * 
 * @Autowired private transitionMapper tm;
 * 
 * @Autowired private transitionstateMapper tsm;
 * 
 * @Autowired private _eventMapper em;
 * 
 * @Autowired private _stateMapper sm;
 * 
 * @Autowired private deviceMapper dMapper;
 * 
 * @Autowired private busMapper bm;
 * 
 * @Autowired private communicationchannelMapper cchannelMapper;
 * 
 * @Autowired private MessageChannelMapper mcm;
 * 
 * @Autowired private InvocationChannelMapper ivcm;
 * 
 * @Autowired private _exceptionMapper _em;
 * 
 * @Autowired private rtosMapper rsmMapper;
 * 
 * @Autowired private _taskMapper _tm;
 * 
 * @Autowired private _partitionMapper ptm;
 * 
 * @Autowired private componenttransitionMapper cttm;
 * 
 * @Autowired private dataobjectMapper dobjm;
 * 
 * private int insert_partition(_partition p) { return ptm.insert(p); }
 * 
 * private int insert_component(component c) { return camArchMapper.insert(c); }
 * 
 * private int insert_bus(bus b) { return bm.insert(b); }
 * 
 * private int insert_ports(linkpoint p) { return portsMapper.insert(p); }
 * 
 * private int insert_require(_require r) { return rm.insert(r); }
 * 
 * private int insert_provide(_provide p) { return pM.insert(p); }
 * 
 * private int insert_cchannel(communicationchannel c) { return
 * cchannelMapper.insert(c); }
 * 
 * private int insert_mchannel(MessageChannel m) { return mcm.insert(m); }
 * 
 * private int insert_ivcchannel(InvocationChannel i) { return ivcm.insert(i); }
 * 
 * private int insert_device(device d) { return dMapper.insert(d); }
 * 
 * private int insert_task(_task t) { return _tm.insert(t); }
 * 
 * private int insert_transition(transition t) { return tm.insert(t); }
 * 
 * private int insert_tss(transitionstate ts) { return tsm.insert(ts); }
 * 
 * private int insert_rtos(rtos r) { return rsmMapper.insert(r); }
 * 
 * private int insert_state(_state s) { return sm.insert(s); }
 * 
 * private int insert_event(_event e) { return em.insert(e); }
 * 
 * private int insert_exception(_exception e) { return _em.insert(e); }
 * 
 * public Integer getPortIDByComponentName(String name, String portname) {
 * Integer aIntegers = camArchMapper.getPortIDByComponentName(name, portname);
 * return camArchMapper.getPortIDByComponentName(name, portname); }
 * 
 * public Integer getCmpIDbyName(String name) { return
 * camArchMapper.getIDbyName(name).getComponentid(); }
 * 
 * public Integer getCChannelBysd(Integer sid, Integer did) { return
 * cchannelMapper.getCChannelBysd(sid, did); }
 * 
 * public Integer getEventID(String eventname) { return
 * em.getEventID(eventname).getEventid(); }
 * 
 * public Integer getStateID(String statename) { return
 * sm.getStateID(statename); }
 * 
 * public void setAadlFiles(Map<String, String> aadlFiles) { this.aadlFiles =
 * aadlFiles; }
 * 
 * public static Document ModelResolver(String url) throws DocumentException {
 * SAXReader reader = new SAXReader(); Document document = reader.read(url);
 * return document; }
 * 
 * // 模型元素与元模型进行匹配 public void srvmatchmeta() throws Exception {
 * AADLResolver.modeldirectory =
 * "src/main/resources/modelresource/MarkedModelFile/";
 * AADLResolver.compositelibfile = aadlFiles.get("组件库"); AADLResolver.errlibfile
 * = aadlFiles.get("错误库"); AADLResolver.hardmodelfile = aadlFiles.get("总体架构");
 * MatchComponents(hardmodelfile, "总体架构"); rtoslist.forEach((v) -> {
 * insert_rtos(v); }); buslist.forEach((v) -> { insert_bus(v); });
 * devicelist.forEach((v) -> { insert_device(v); });
 * 
 * MatchCChannel(hardmodelfile, "aadl"); cclist.forEach((v) -> {
 * insert_cchannel(v); }); mclist.forEach((v) -> { insert_mchannel(v); });
 * ivclist.forEach((v) -> { insert_ivcchannel(v); }); String[] innersysfile =
 * aadlFiles.get("系统内部结构").split(";"); for (String s : innersysfile) { if (s !=
 * null) {
 * 
 * AADLResolver.dynamicfilename = s; InnerSystem(dynamicfilename);
 * 
 * Document d = ModelResolver(s); List<? extends Node> nodes =
 * d.selectNodes("//ownedClassifier[@xsi:type='aadl2:SystemImplementation']");
 * for (Node n : nodes) { StateResolver(s, ((Element) n).attributeValue("id"));
 * }
 * 
 * scheduleResolver(s); partitionResolver(s); }
 * 
 * } ExceptionResolver(dynamicfilename, "aadl"); exceptionlist.forEach((v) -> {
 * insert_exception(v); }); // } if (errlibfile != null) { //
 * eventResolver(aadlFiles.get("系统内部结构"), "aadl"); }
 * 
 * }
 * 
 * 当前模型的全部组件与port、task public void MatchComponents(String filepath, String
 * contenttype) throws Exception { Document document = ModelResolver(filepath);
 * if (contenttype.equals("总体架构")) { Element systemElement = (Element)
 * document.selectSingleNode("//ownedClassifier[@name='isolette']"); component
 * system = new component();
 * system.setName(systemElement.attributeValue("name"));
 * system.setModeltype("aadl"); system.setType("uniquesystem"); // 暂时只有这一个属性
 * system.setWcet(systemElement.element("ownedPropertyAssociation").element(
 * "ownedValue").element("ownedValue") .attributeValue("value") + "ms"); Integer
 * id = (int) GetID.getId(); system.setComponentid(id);
 * insert_component(system); } // 对hardware层级设计的三种与组件元素的解析 String getbus =
 * "//ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedBusSubcomponent";
 * String getsys =
 * "//ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedSystemSubcomponent";
 * String getdevice =
 * "//ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedDeviceSubcomponent";
 * components = document.selectNodes(getbus); ResolveComponents(filepath,
 * "bus"); components = document.selectNodes(getsys);
 * ResolveComponents(filepath, "sys"); components =
 * document.selectNodes(getdevice); ResolveComponents(filepath, "device"); }
 * 
 * // filename参数是hardwareArchitecture public void MatchCChannel(String
 * modelfilename, String modelType) throws Exception { Document document =
 * ModelResolver(modelfilename); List<String> namelist = new ArrayList<>(); if
 * (modelType.equals("aadl")) { String getCChannel = ""; // hardware层的cchannel解析
 * // bus access或者叫asyncmessaging String getmessagechannel =
 * "//ownedPublicSection/ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedAccessConnection";
 * cchannels = document.selectNodes(getmessagechannel);
 * ResolveCChannel(modelfilename, "asyncmessaging"); // invocationChannel //
 * aadl将连接放在总体架构中 String getsync =
 * "//ownedPublicSection/ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedPortConnection";
 * cchannels = document.selectNodes(getsync); ResolveCChannel(modelfilename,
 * "sync"); // dispatchChannel // TODO 修改案例完成dispatchChannel的解析xpath // String
 * getdc = "//ownedPublicSection/"; // cchannels = document.selectNodes(getdc);
 * // ResolveCChannel(modelfilename, "dispatchChannel"); } }
 * 
 * private void ResolveCChannel(String modelfilename, String t) throws Exception
 * { for (Node n : cchannels) { Element element = (Element) n;
 * communicationchannel cchannel = new communicationchannel(); Integer idString
 * = (int) GetID.getId(); cchannel.setName(element.attributeValue("name"));
 * cchannel.setCommunicationchannelid(idString); cchannel.setModeltype("aadl");
 * switch (t) { case "asyncmessaging": // TODO 解析dispatch的source,dest // TODO
 * 解析inbuffer,outbuffer // context是目标元素在本文件中的路径 // connectionEnd是连了哪个端口 //
 * source有context是组件向bus发送，没有context是组件接收bus的数据 if
 * (element.element("source").attribute("context") != null) { // inbuffer //
 * 解析source // 端口会重名但是组件名不会，先找组件名再找组件名下的端口id String CompositeName =
 * GetName(modelfilename, element.element("source").attributeValue("context"));
 * String PortName = GetName(compositelibfile,
 * element.element("source").attributeValue("connectionEnd"));
 * 
 * Integer sourceportid = getPortIDByComponentName(CompositeName, PortName);
 * cchannel.setSourceid(sourceportid); } else { // outbuffer // 此时source是bus
 * String busname = GetName(modelfilename,
 * element.element("source").attributeValue("connectionEnd")); Integer busid =
 * getCmpIDbyName(busname); cchannel.setSourceid(busid); } //
 * dest没有context是组件向bus发送，有context是组件接收bus的数据 if
 * (element.element("destination").attribute("context") == null) { // inbuffer
 * // dest是bus String busname = GetName(modelfilename,
 * element.element("destination").attributeValue("connectionEnd")); Integer
 * busid = getCmpIDbyName(busname); cchannel.setDestid(busid); } else { //
 * outbuffer // dest是端口 String CompositeName = GetName(modelfilename,
 * element.element("destination").attributeValue("context")); // String PortName
 * =
 * GetName("src/main/resources/modelresource/JH_FK/packages/Composition.aaxl2",
 * // element.element("destination").attributeValue("connectionEnd")); String
 * PortName = GetName(compositelibfile,
 * element.element("destination").attributeValue("connectionEnd"));
 * 
 * Integer destportid = getPortIDByComponentName(CompositeName, PortName);
 * cchannel.setDestid(destportid); } cchannel.setType("asyncmessaging");
 * MessageChannel b = new MessageChannel(); b.setMessagechannelid(idString);
 * mclist.add(b); break; case "sync": // String CompositeName =
 * GetName(modelfilename, element.element("source").attributeValue("context"));
 * // String PortName = GetName(compositelibfile,
 * element.element("source").attributeValue("connectionEnd")); // Integer
 * sourceportid = getPortIDByComponentName(CompositeName, PortName); // 正则获取文件名
 * String CompositeFIleName = modeldirectory +
 * Getfilename(element.element("source").attributeValue("connectionEnd"));
 * String sourceportid = GetElementID(CompositeFIleName,
 * element.element("source").attributeValue("connectionEnd")); if
 * (sourceportid.equals("")) { cchannel.setSourceid(0); } else {
 * cchannel.setSourceid(Integer.valueOf(sourceportid)); }
 * 
 * // String CompositeName1 = GetName(modelfilename, //
 * element.element("destination").attributeValue("context")); String
 * CompositeName1 = modeldirectory +
 * Getfilename(element.element("destination").attributeValue("connectionEnd"));
 * // String PortName1 = GetName(compositelibfile, //
 * element.element("destination").attributeValue("connectionEnd")); String
 * destid = GetElementID(CompositeName1,
 * element.element("destination").attributeValue("connectionEnd")); // Integer
 * destportid = getPortIDByComponentName(CompositeName1, PortName1); //
 * 有的没source dest if (destid.equals("")) { cchannel.setDestid(0); } else {
 * cchannel.setDestid(Integer.valueOf(destid)); } cchannel.setType("sync");
 * InvocationChannel r = new InvocationChannel();
 * r.setInvocationchannelid(idString); ivclist.add(r); break; case
 * "dispatchChannel": cchannel.setType("dispatchChannel"); DispatchChannel d =
 * new DispatchChannel(); d.setDispatchchannelid(idString); dpclist.add(d);
 * break; } cclist.add(cchannel); } }
 * 
 * public void initComponentID(String filepath) throws Exception { String getbus
 * =
 * "//ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedBusSubcomponent";
 * String getdevice =
 * "//ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedDeviceSubcomponent";
 * String getsys =
 * "//ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedSystemSubcomponent";
 * Document document = ModelResolver(filepath); List<? extends Node> nodes =
 * document.selectNodes(getbus); for (Node n : nodes) { Integer idString = (int)
 * GetID.getId(); AppendID.AppendID(filepath, n.getUniquePath(),
 * idString.toString()); } nodes = document.selectNodes(getsys);
 * nodes.forEach((v) -> { Integer idString2 = (int) GetID.getId(); try {
 * AppendID.AppendID(filepath, v.getUniquePath(), idString2.toString()); } catch
 * (Exception e) { e.printStackTrace(); } }); nodes =
 * document.selectNodes(getdevice); for (Node n : nodes) { Integer idString3 =
 * (int) GetID.getId(); AppendID.AppendID(filepath, n.getUniquePath(),
 * idString3.toString()); } }
 * 
 * // TODO rtos与processor的关系绑定 public void InnerSystem(String modelfilename)
 * throws Exception { Document document = ModelResolver(modelfilename); String
 * getsys = "//ownedClassifier[@xsi:type='aadl2:SystemImplementation']"; Element
 * sysElement = (Element) document.selectSingleNode(getsys);
 * 
 * // 从集成的角度看，先直接解析task，等以后有了shcedule再绑定上级 // String gettask =
 * "//ownedClassifier[@xsi:type='aadl2:ProcessType' or
 * // @xsi:type='aadl2:ThreadType']"; String gettask =
 * "//ownedClassifier[@xsi:type='aadl2:ProcessType']"; // 查找系统内部的组件
 * 
 * String innerDevcvice = "//ownedClassifier[@xsi:type='aadl2:ProcessorType']";
 * components = document.selectNodes(innerDevcvice);
 * resolverChild(modelfilename, "device");
 * 
 * components = document.selectNodes(gettask); TaskResolver(modelfilename,
 * Integer.valueOf(sysElement.attributeValue("id"))); // task间的连接 document =
 * ModelResolver(modelfilename); List<Node> portconnectionlist = document
 * .selectNodes(
 * "//ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedPortConnection"
 * ); for (Node n2 : portconnectionlist) { Element e = (Element) n2; connections
 * c = new connections(); c.setFathercmpid(e.getParent().attributeValue("id"));
 * if (e.element("source").attributeValue("context") != null) { //
 * 没有context是指当前组件 Element declare = (Element) document
 * .selectSingleNode(GetXPath(e.element("source").attributeValue("context")));
 * // 这里指向声明！ Element sourcecomponent = (Element) document
 * .selectSingleNode(GetXPath42layer(declare.attributeValue(
 * "processSubcomponentType")));
 * c.setStartcomponentid(Integer.valueOf(sourcecomponent.attributeValue("id")));
 * } else {
 * c.setStartcomponentid(Integer.valueOf(e.getParent().attributeValue("id"))); }
 * Element sourceport = (Element) document
 * .selectSingleNode(GetXPath(e.element("source").attributeValue("connectionEnd"
 * ))); c.setStartinterface(sourceport.attributeValue("id")); if
 * (e.element("destination").attributeValue("context") != null) { Element
 * declare = (Element) document
 * .selectSingleNode(GetXPath(e.element("destination").attributeValue("context")
 * )); Element dstcomponent = (Element) document
 * .selectSingleNode(GetXPath42layer(declare.attributeValue(
 * "processSubcomponentType")));
 * c.setEndcomponentid(Integer.valueOf(dstcomponent.attributeValue("id")));
 * 
 * } else {
 * c.setEndcomponentid(Integer.valueOf(e.getParent().attributeValue("id"))); }
 * Element dstport = (Element) document
 * .selectSingleNode(GetXPath(e.element("destination").attributeValue(
 * "connectionEnd"))); c.setEndinterface(dstport.attributeValue("id"));
 * cm.insert(c); } // SystemType的错误附件影响到下级的实现
 * 
 * String getallsysimpl =
 * "//ownedClassifier[@xsi:type='aadl2:SystemImplementation']"; List<? extends
 * Node> nodes = document.selectNodes(getallsysimpl); for (Node n : nodes) {
 * Element e = (Element) n; // StateResolver(modelfilename,
 * e.attributeValue("id")); } }
 * 
 * // 内部的deivce与上级元素都需要放进component表中 private void resolverChild(String filepath,
 * String t) throws Exception { List<? extends Node> ports = null; for (Node n :
 * components) { Element element = (Element) n; Integer idString2 = (int)
 * GetID.getId();
 * 
 * AppendID.AppendID(filepath, n.getUniquePath(), idString2.toString());
 * 
 * component component = new component(); component.setModeltype("aadl");
 * component.setName(element.attributeValue("name"));
 * component.setComponentid(idString2); component.setType("partition");
 * 
 * insert_component(component); // partition // String
 * a=element.attributeValue("xsi:type"); // if
 * (element.attributeValue("xsi:type").equals("aadl2:ProcessorType")) { //
 * _partition partition = new _partition(); //
 * partition.setPartitionid(idString2); // partition.setRtosid(); //
 * partitionlist.add(partition); // } // RTOS与partition的部署关系 // device d = new
 * device(); // d.setDeviceid(idString2); // devicelist.add(d); // 名下的linkpoint
 * String devicedef = modeldirectory +
 * Getfilename(element.attributeValue("deviceSubcomponentType"));
 * LinkpointResolver(devicedef, ports, idString2, t,
 * element.attributeValue("name"));
 * 
 * // componentlist.put(element.attributeValue("name"), component); } }
 * 
 * private void ResolveComponents(String filepath, String t) throws Exception {
 * List<? extends Node> ports = null; for (Node n : components) { Element
 * element = (Element) n; component component = new component();
 * 
 * Integer componentID = Integer.valueOf(element.attributeValue("id")); //
 * AppendID.AppendID(filepath, element.getPath(), idString.toString());
 * 
 * component.setModeltype("aadl");
 * component.setName(element.attributeValue("name"));
 * component.setComponentid(componentID); switch (t) { case "bus":
 * component.setType("bus"); camArchMapper.insert(component); bus b = new bus();
 * b.setBusid(componentID); buslist.add(b); break; case "sys": dynamicfilename =
 * Getfilename(element.attributeValue("systemSubcomponentType"));
 * 
 * component.setType("rtos");
 * 
 * String getwcetinsys = "//ownedPublicSection/ownedClassifier[@name='" +
 * component.getName() +
 * "']/ownedPropertyAssociation[contains(@property,'wcet4sys')]"; Document
 * document1 = ModelResolver(modeldirectory + dynamicfilename); Element
 * sysElement = (Element) document1.selectSingleNode(getwcetinsys); if
 * (sysElement != null) { component.setWcet(
 * sysElement.element("ownedValue").element("ownedValue").attributeValue(
 * "value") + "ms"); }
 * 
 * camArchMapper.insert(component); rtos r = new rtos();
 * r.setRtosid(componentID); // TODO 设置partitions的数量 rtoslist.add(r);
 * 
 * String sysdef = modeldirectory +
 * Getfilename(element.attributeValue("systemSubcomponentType"));
 * LinkpointResolver(sysdef, ports, componentID, t,
 * element.attributeValue("name"));
 * 
 * break; case "device": component.setType("device"); String getwcet =
 * "//ownedPublicSection/ownedClassifier[@name='" + component.getName() +
 * "']/ownedPropertyAssociation[contains(@property,'wcet4dev')]"; Document
 * document = ModelResolver(compositelibfile); Element devicElement = (Element)
 * document.selectSingleNode(getwcet); if (devicElement != null) {
 * component.setWcet(
 * devicElement.element("ownedValue").element("ownedValue").attributeValue(
 * "value") + "ms"); } camArchMapper.insert(component); device d = new device();
 * d.setDeviceid(componentID); devicelist.add(d); // 名下的linkpoint // String
 * devicedef = modeldirectory + //
 * Getfilename(element.attributeValue("deviceSubcomponentType"));
 * 
 * LinkpointResolver(compositelibfile, ports, componentID, t,
 * element.attributeValue("name")); break; }
 * 
 * // componentlist.put(element.attributeValue("name"), component); } }
 * 
 * private void LinkpointResolver(String linkpointfile, List<? extends Node>
 * ports, Integer fatherid, String fathertype, String componetname) throws
 * Exception { switch (fathertype) { case "bus": case "device": Document
 * document = ModelResolver(compositelibfile); //
 * 构建linkpoint,分开处理busaccess与dataport,eventport,busaccess看require属性,
 * dataport与之前相同 // bussaccess ports = document
 * .selectNodes("//ownedPublicSection/ownedClassifier[@name='" + componetname +
 * "']/ownedBusAccess"); TraverseOwnedPorts(ports, fatherid, "busaccess"); //
 * dataport ports = document
 * .selectNodes("//ownedPublicSection/ownedClassifier[@name='" + componetname +
 * "']/ownedDataPort"); TraverseOwnedPorts(ports, fatherid, "dataport"); //
 * eventport ports = document
 * .selectNodes("//ownedPublicSection/ownedClassifier[@name='" + componetname +
 * "']/ownedEventPort"); // 对应关系，busaccess对应----- eventport对应------
 * dataport对应-------- TraverseOwnedPorts(ports, fatherid, "eventport"); break;
 * case "sys": Document document2 = ModelResolver(linkpointfile);
 * dynamicfilename = linkpointfile; // 同上 ports = document2.selectNodes(
 * "//ownedClassifier[@xsi:type='aadl2:SystemType']/ownedDataPort");
 * TraverseOwnedPorts4Sys(ports, fatherid, "dataport"); ports =
 * document2.selectNodes(
 * "//ownedClassifier[@xsi:type='aadl2:SystemType']/ownedEventPort");
 * TraverseOwnedPorts4Sys(ports, fatherid, "eventport"); ports =
 * document2.selectNodes(
 * "//ownedClassifier[@xsi:type='aadl2:SystemType']/ownedBusAccess");
 * TraverseOwnedPorts4Sys(ports, fatherid, "busaccess"); break; } }
 * 
 * private void TraverseOwnedPorts4Sys(List<? extends Node> ports, Integer
 * fatherid, String portType) throws Exception { for (Node n2 : ports) { Element
 * portElement = (Element) n2;
 * 
 * linkpoint ports1 = new linkpoint(); // 暂时只设置name这一个
 * ports1.setName(portElement.attributeValue("name"));
 * ports1.setModeltype("aadl"); Integer linkpointID = (int) GetID.getId();
 * ports1.setLinkpointid(linkpointID); // 获取data // 目前设定为只读取定义在composition中的data
 * try { String[] datapath =
 * portElement.attributeValue("dataFeatureClassifier").split("\\."); String f =
 * Getfilename(portElement.attributeValue("dataFeatureClassifier")); Document d
 * = ModelResolver(modeldirectory + f); List<Node> datalist = d
 * .selectNodes("//ownedClassifier[@xsi:type='aadl2:DataType' and @name='" +
 * datapath[2] + "']"); for (Node node : datalist) { Element dataElement =
 * (Element) node; List<Element> props =
 * dataElement.elements("ownedPropertyAssociation"); for (Element e : props) {
 * if (e.attributeValue("property").contains("period")) { ports1.setPeriod(
 * e.element("ownedValue").element("ownedValue").attributeValue("value") +
 * "ms"); } if (e.attributeValue("property").contains("porttype")) {
 * 
 * dataobject doj = new dataobject();
 * doj.setDatatype(e.element("ownedValue").element("ownedValue").attributeValue(
 * "value")); doj.setFrom(linkpointID); dobjm.insert(doj); } } } } catch
 * (Exception e) { e.printStackTrace(); } portsMapper.insert(ports1);
 * 
 * switch (portType) { case "dataport": case "eventport": syncinterface si = new
 * syncinterface(); si.setSyncinterfaceid(linkpointID); try {
 * AppendID.AppendID(dynamicfilename, portElement.getUniquePath(),
 * linkpointID.toString()); } catch (Exception e) { e.printStackTrace(); }
 * 
 * if (!(portElement.attribute("in") == null)) { // 是输入端口 _require r = new
 * _require(); r.setRequired(linkpointID); r.setRequirer(fatherid);
 * rm.insert(r); requirelist.add(r); } else { _provide p = new _provide();
 * p.setProvided(linkpointID); p.setProvider(fatherid); pM.insert(p);
 * providelist.add(p); } break; case "busaccess":
 * AppendID.AppendID(dynamicfilename, portElement.getUniquePath(),
 * linkpointID.toString()); ASyncMessaging asm = new ASyncMessaging();
 * asm.setAsyncmessagingid(linkpointID); if
 * (portElement.attribute("kind").equals("requires")) { // 是输入端口 _require r =
 * new _require(); r.setRequired(linkpointID); r.setRequirer(fatherid);
 * rm.insert(r); requirelist.add(r); } else { _provide p = new _provide();
 * p.setProvided(linkpointID); p.setProvider(fatherid); pM.insert(p);
 * providelist.add(p); } break; }
 * 
 * portlist.add(ports1); } }
 * 
 * private void TraverseOwnedPorts(List<? extends Node> ports, Integer fatherid,
 * String portType) throws Exception { for (Node n2 : ports) { Element element2
 * = (Element) n2;
 * 
 * linkpoint ports1 = new linkpoint(); // 暂时只设置name这一个
 * ports1.setName(element2.attributeValue("name")); ports1.setModeltype("aadl");
 * Integer linkpointID = (int) GetID.getId();
 * ports1.setLinkpointid(linkpointID); portsMapper.insert(ports1); switch
 * (portType) { case "dataport": case "eventport": syncinterface si = new
 * syncinterface(); si.setSyncinterfaceid(linkpointID); try {
 * 
 * AppendID.AppendID(compositelibfile, element2.getUniquePath(),
 * linkpointID.toString());
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * if (!(element2.attribute("in") == null)) { // 是输入端口 _require r = new
 * _require(); r.setRequired(linkpointID); r.setRequirer(fatherid);
 * rm.insert(r); } else { _provide p = new _provide();
 * p.setProvided(linkpointID); p.setProvider(fatherid); pM.insert(p); } break;
 * case "busaccess": AppendID.AppendID(compositelibfile,
 * element2.getUniquePath(), linkpointID.toString()); ASyncMessaging asm = new
 * ASyncMessaging(); asm.setAsyncmessagingid(linkpointID); if
 * (element2.attribute("kind").equals("requires")) { // 是输入端口 _require r = new
 * _require(); r.setRequired(linkpointID); r.setRequirer(fatherid);
 * rm.insert(r); } else { _provide p = new _provide();
 * p.setProvided(linkpointID); p.setProvider(fatherid); pM.insert(p); } break; }
 * } }
 * 
 * private void TraverseOwnedPorts4task(String modelfile, List<? extends Node>
 * ports, Integer fatherid, String portType) throws Exception { for (Node n2 :
 * ports) { Element taskportElement = (Element) n2;
 * 
 * linkpoint ports1 = new linkpoint(); // 暂时只设置name这一个
 * ports1.setName(taskportElement.attributeValue("name"));
 * ports1.setModeltype("aadl"); Integer linkpointID = (int) GetID.getId();
 * ports1.setLinkpointid(linkpointID); portsMapper.insert(ports1); switch
 * (portType) { case "dataport": case "eventport": syncinterface si = new
 * syncinterface(); si.setSyncinterfaceid(linkpointID); try {
 * 
 * AppendID.AppendID(modelfile, taskportElement.getUniquePath(),
 * linkpointID.toString());
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * if (!(taskportElement.attribute("in") == null)) { // 是输入端口 _require r = new
 * _require(); r.setRequired(linkpointID); r.setRequirer(fatherid);
 * rm.insert(r); } else { _provide p = new _provide();
 * p.setProvided(linkpointID); p.setProvider(fatherid); pM.insert(p); } break;
 * case "busaccess": AppendID.AppendID(compositelibfile,
 * taskportElement.getUniquePath(), linkpointID.toString()); ASyncMessaging asm
 * = new ASyncMessaging(); asm.setAsyncmessagingid(linkpointID); if
 * (taskportElement.attribute("kind").equals("requires")) { // 是输入端口 _require r
 * = new _require(); r.setRequired(linkpointID); r.setRequirer(fatherid);
 * rm.insert(r); } else { _provide p = new _provide();
 * p.setProvided(linkpointID); p.setProvider(fatherid); pM.insert(p); } break; }
 * } }
 * 
 * // 错误附件的解析 public void ExceptionResolver(String modelfilename, String
 * modelType) throws Exception { Document document =
 * ModelResolver(modelfilename);
 * 
 * List<? extends Node> nodelist = new ArrayList<>(); if
 * (modelType.equals("aadl")) { // 读取system节点 nodelist =
 * document.selectNodes("//ownedClassifier[@xsi:type='aadl2:SystemType']");
 * nodelist.forEach((v) -> {
 * 
 * Element systemElement = (Element) v;
 * 
 * try { String[] behaviorcontent = systemElement.element("ownedAnnexSubclause")
 * .element("parsedAnnexSubclause").attributeValue("useBehavior").split("\\.");
 * String behaviorname = behaviorcontent[2]; eventResolver(modelfilename,
 * "aadl");
 * 
 * String getimpl = systemElement.getUniquePath() +
 * "/following-sibling::ownedClassifier[@name='" +
 * systemElement.attributeValue("name") + ".impl" + "']"; Element implElement =
 * (Element) document.selectSingleNode(getimpl); // 因为解析路径有些相似就顺手放在这里了 String
 * getwcet = systemElement.getUniquePath() +
 * "/ownedPropertyAssociation[contains(@property,'wcet4sys')]/ownedValue/ownedValue";
 * Element wcetElement = (Element) document.selectSingleNode(getwcet); component
 * c = new component();
 * c.setComponentid(Integer.valueOf(implElement.attributeValue("id")));
 * c.setWcet(wcetElement.attributeValue("value") + "ms");
 * camArchMapper.updateByPrimaryKeySelective(c);
 * 
 * TransitionResolver(behaviorname, implElement.attributeValue("id")); } catch
 * (Exception e1) { e1.printStackTrace(); } String compositename =
 * systemElement.attributeValue("name");
 * 
 * _exception e = new _exception();
 * e.setName(systemElement.element("ownedAbstractFeature").attributeValue("name"
 * ));
 * 
 * Element typesetElement =
 * systemElement.element("ownedAnnexSubclause").element("parsedAnnexSubclause")
 * .element("propagations").element("typeSet"); List<Element> typelist =
 * typesetElement.elements("typeTokens"); StringBuffer exceptionTypeString = new
 * StringBuffer(); for (Element typElement : typelist) {
 * exceptionTypeString.append(getType(typElement.attributeValue("type")) + "、");
 * } e.setType(exceptionTypeString.toString());
 * 
 * String getimpl = systemElement.getUniquePath() +
 * "/following-sibling::ownedClassifier[@name='" +
 * systemElement.attributeValue("name") + ".impl" + "']"; Element implElement =
 * (Element) document.selectSingleNode(getimpl);
 * e.setComponentid(Integer.valueOf(implElement.attributeValue("id")));
 * 
 * systemElement =
 * systemElement.element("ownedAnnexSubclause").element("parsedAnnexSubclause")
 * .element("propagations"); Integer sourceid = 0, destid = 0; // 没有direction或者
 * if (systemElement.attribute("direction") != null &&
 * systemElement.attributeValue("direction").equals("out")) { String
 * getsourceportPath =
 * systemElement.element("featureorPPRef").attributeValue("featureorPP"); try {
 * Element portElement = (Element)
 * document.selectSingleNode(GetXPath(getsourceportPath)); sourceid =
 * Integer.valueOf(portElement.attributeValue("id")); // sourceid =
 * getPortIDByComponentName(compositename, // GetName(modelfilename,
 * GetXPath(getsourceportPath))); e.setLinkpointid(sourceid); } catch (Exception
 * e1) { e1.printStackTrace(); } } else {
 * 
 * String getsourceportPath =
 * systemElement.element("featureorPPRef").attributeValue("featureorPP"); try {
 * // destid = getPortIDByComponentName(compositename, // GetName(modelfilename,
 * GetXPath(getsourceportPath))); Element portElement = (Element)
 * document.selectSingleNode(GetXPath(getsourceportPath)); // TODO 设置propagation
 * linkpoint destid = Integer.valueOf(portElement.attributeValue("id"));
 * e.setLinkpointid(destid); } catch (Exception e1) { e1.printStackTrace();
 * System.out.println(compositename + getsourceportPath); }
 * 
 * } e.setCommunicationchannelid(getCChannelBysd(sourceid, destid));
 * 
 * exceptionlist.add(e); });
 * 
 * } }
 * 
 * // 需要的文件是系统内部结构，而且要先解析错误库中的event public void TransitionResolver(String
 * behaviorname, String cmpid) throws Exception { Document document =
 * ModelResolver(errlibfile); List<? extends Node> transNodes = document
 * .selectNodes("//parsedAnnexLibrary/behaviors[@name='" + behaviorname +
 * "']/transitions");
 * 
 * transNodes.forEach((v) -> { Element element = (Element) v; //
 * transition与作为trigger的event关联 String getTriggerevent =
 * element.element("condition").element("qualifiedErrorPropagationReference")
 * .element("emv2Target").attributeValue("namedElement");
 * 
 * transition t = new transition(); try { t.setTransitionid((int)
 * GetID.getId()); // 关联event Document d = ModelResolver(errlibfile); String
 * eventpathString = GetXPath4State(getTriggerevent); Node nodes =
 * d.selectSingleNode(eventpathString); String id = ((Element)
 * nodes).attributeValue("id"); t.setTriggerid(Integer.valueOf(id));
 * t.setName(getType(element.attributeValue("name")));
 * 
 * insert_transition(t); transitionstate tsTransitionstate = new
 * transitionstate();
 * 
 * // 这里需要先解析到state Element stateelement = (Element) document
 * .selectSingleNode(GetXPath4State(element.attributeValue("source")));
 * tsTransitionstate.setSourceid(Integer.valueOf(stateelement.attributeValue(
 * "id"))); if (element.attributeValue("target") != null) {
 * 
 * stateelement = (Element) document
 * .selectSingleNode(GetXPath4State(element.attributeValue("target")));
 * tsTransitionstate.setOutid(Integer.valueOf(stateelement.attributeValue("id"))
 * );
 * 
 * tsTransitionstate.setTransitionid(t.getTransitionid());
 * insert_tss(tsTransitionstate);
 * 
 * componenttransition cmpts = new componenttransition();
 * cmpts.setComponentid(cmpid);
 * cmpts.setTransitionid(t.getTransitionid().toString()); cttm.insert(cmpts); }
 * } catch (Exception e) { e.printStackTrace(); } }); }
 * 
 * // 系统内部结构 public void eventResolver(String modelfilename, String modelType)
 * throws Exception { // TODO 下一个event的确定 // 外部的event Document d =
 * ModelResolver(errlibfile); List<? extends Node> outevent = d .selectNodes(
 * "//ownedPublicSection/ownedAnnexLibrary/parsedAnnexLibrary/behaviors/events")
 * ; for (Node n : outevent) { Element element = (Element) n; _event e2 = new
 * _event(); e2.setName(element.attributeValue("name")); Integer idString =
 * (int) GetID.getId(); e2.setEventid(idString); AppendID.AppendID(errlibfile,
 * n.getUniquePath(), idString.toString()); insert_event(e2); //
 * eventlist.add(e2); } // 解析错内部的event Document document =
 * ModelResolver(modelfilename); List<? extends Node> erroreventName =
 * document.selectNodes("//ownedAnnexSubclause/parsedAnnexSubclause/events");
 * erroreventName.forEach((v) -> { Element element = (Element) v; _event e2 =
 * new _event(); e2.setName(element.attributeValue("name")); Integer idString =
 * (int) GetID.getId(); try { AppendID.AppendID(modelfilename,
 * v.getUniquePath(), idString.toString()); } catch (Exception e) {
 * e.printStackTrace(); } insert_event(e2); // eventlist.add(e2); });
 * 
 * }
 * 
 * // 需要系统内部结构文件,state是组件的state private void StateResolver(String modelfilename,
 * String Compositeid) throws Exception { // TODO state与interface的关联 Document
 * document = ModelResolver(modelfilename);
 * 
 * List<? extends Node> stateInfo = document .selectNodes(
 * "//ownedAnnexSubclause/parsedAnnexSubclause/states/condition/operands/operands"
 * ); if (stateInfo.size() != 0) { // 文件中定义了state stateInfo.forEach((v) -> {
 * Element element = (Element) v; try { AppendID.AppendID(modelfilename,
 * v.getUniquePath(), Compositeid); } catch (Exception e2) {
 * e2.printStackTrace(); } String statenameString =
 * element.element("qualifiedState").attributeValue("state");
 * 
 * String cmpID =
 * element.element("qualifiedState").element("subcomponent").attributeValue(
 * "subcomponent"); _state s = new _state(); try { //
 * s.setComponentid(getCmpIDbyName(GetName(hardmodelfile, GetXPath(cmpID))));
 * s.setComponentid(Integer.valueOf(Compositeid)); s.setName(GetName(errlibfile,
 * GetXPath4State(statenameString))); } catch (Exception e) { } insert_state(s);
 * // statelist.add(s); }); } //
 * 5.10添加解析规则：如果引用了behavior则错误库中该behavior下的state一并引入进来 Node behaviorInfo =
 * document.selectSingleNode("//ownedAnnexSubclause/parsedAnnexSubclause"); if
 * (behaviorInfo != null) { Element e1 = (Element) behaviorInfo; try { String s
 * = "//ownedAnnexLibrary/parsedAnnexLibrary/behaviors[@name='" +
 * getType(e1.attributeValue("useBehavior")) + "']/states"; List<? extends Node>
 * libstateinfo = ModelResolver(errlibfile).selectNodes(s);
 * libstateinfo.forEach((v) -> { Integer idString = (int) GetID.getId(); try {
 * AppendID.AppendID(errlibfile, v.getUniquePath(), idString.toString()); }
 * catch (Exception e) { e.printStackTrace(); } _state stat = new _state();
 * stat.setStateid(idString); stat.setComponentid(Integer.valueOf(Compositeid));
 * stat.setName(((Element) v).attributeValue("name")); insert_state(stat); //
 * statelist.add(stat); }); } catch (Exception e) { e.printStackTrace(); } } }
 * 
 * // 获取Exception的类型 private static String getType(String typepath) { if
 * (typepath != null && typepath.contains(".")) {
 * 
 * String[] s = typepath.split("\\."); return s[s.length - 1]; } return ""; }
 * 
 * private void TaskResolver(String modelfilename, Integer fatherid) throws
 * Exception {
 * 
 * for (Node n : components) { // 解析component Element taskElement = (Element) n;
 * 
 * component component = new component(); Integer idString = (int)
 * GetID.getId();
 * 
 * AppendID.AppendID(modelfilename, n.getUniquePath(), idString.toString());
 * 
 * component.setComponentid(idString);
 * 
 * component.setModeltype("aadl");
 * component.setName(taskElement.attributeValue("name"));
 * component.setType("task"); insert_component(component);
 * 
 * // 解析task _task t = new _task(); t.setName(component.getName());
 * t.setTaskid(idString); t.setFatherid(fatherid); List<Element> ports =
 * taskElement.elements("ownedDataPort"); TraverseOwnedPorts4task(modelfilename,
 * ports, idString, "dataport");
 * 
 * List<? extends Node> prop = taskElement.elements("ownedPropertyAssociation");
 * for (Node n2 : prop) { Element e2 = (Element) n2; if
 * (e2.attributeValue("property").contains("Deadline")) { String getdeadline =
 * e2.element("ownedValue").element("ownedValue").attributeValue("value");
 * t.setDeadline(getdeadline + "ms"); } if
 * (e2.attributeValue("property").contains("Period")) { String getperiod =
 * e2.element("ownedValue").element("ownedValue").attributeValue("value");
 * t.setPeriod(getperiod + "ms"); } // 是process,这里暂时规定process的wcet就叫wcet if
 * (e2.attributeValue("property").contains("wcet")) { String getwcet =
 * e2.element("ownedValue").element("ownedValue").attributeValue("value");
 * t.setWcet(getwcet + "ms"); } } // 要到impl里去找 Document document =
 * ModelResolver(modelfilename); String getimpl = taskElement.getUniquePath() +
 * "/following-sibling::ownedClassifier[@name='" +
 * taskElement.attributeValue("name") + ".impl" + "']";
 * 
 * threadResolver(taskElement, idString, getimpl, modelfilename);
 * insert_task(t);
 * 
 * // thread的连接 // 文档变化了,document要重新加载 document = ModelResolver(modelfilename);
 * List<Node> portconnectionlist = document.selectNodes(getimpl +
 * "/ownedPortConnection"); for (Node n2 : portconnectionlist) { Element e =
 * (Element) n2; connections c = new connections();
 * c.setFathercmpid(e.getParent().attributeValue("id"));
 * c.setConnectiontype(e.attributeValue("name")); if
 * (e.element("source").attributeValue("context") != null) { // 没有context是指当前组件
 * Element sourcecomponent = (Element) document
 * .selectSingleNode(GetXPath(e.element("source").attributeValue("context")));
 * c.setStartcomponentid(Integer.valueOf(sourcecomponent.attributeValue("id")));
 * } else { c.setStartcomponentid(Integer.valueOf(idString)); } Element
 * sourceport = (Element) document
 * .selectSingleNode(GetXPath(e.element("source").attributeValue("connectionEnd"
 * ))); c.setStartinterface(sourceport.attributeValue("id"));
 * 
 * if (e.element("destination").attributeValue("context") != null) { Element
 * dstcomponent = (Element) document
 * .selectSingleNode(GetXPath(e.element("destination").attributeValue("context")
 * )); c.setEndcomponentid(Integer.valueOf(dstcomponent.attributeValue("id")));
 * 
 * } else { c.setEndcomponentid(Integer.valueOf(idString)); } Element dstport =
 * (Element) document
 * .selectSingleNode(GetXPath(e.element("destination").attributeValue(
 * "connectionEnd"))); c.setEndinterface(dstport.attributeValue("id"));
 * cm.insert(c); } } }
 * 
 * private void threadResolver(Element fatherdeclare, Integer fatherid, String
 * rawimplpath, String modelfilename) throws Exception { Document d =
 * ModelResolver(modelfilename); Element e = (Element)
 * d.selectSingleNode(rawimplpath); AppendID.AppendID(modelfilename,
 * e.getUniquePath(), fatherid.toString()); // 指向了impl List<Element> thread =
 * e.elements("ownedThreadSubcomponent"); if (thread.size() > 0) { for (Element
 * e2 : thread) { Element theadElement = (Element) d
 * .selectSingleNode(GetXPath42layer(e2.attributeValue("threadSubcomponentType")
 * ));
 * 
 * // 找的是impl，dataport这次又定义在声明里面！ component component = new component(); Integer
 * idString = (int) GetID.getId(); AppendID.AppendID(modelfilename,
 * e2.getUniquePath(), idString.toString()); AppendID.AppendID(modelfilename,
 * theadElement.getUniquePath(), idString.toString());
 * 
 * component.setComponentid(idString); component.setModeltype("aadl");
 * component.setName(theadElement.attributeValue("name"));
 * component.setType("task"); insert_component(component); // 这里他又指向impl....
 * String getdeclare = theadElement.getUniquePath() +
 * "/preceding-sibling::ownedClassifier[@name='" +
 * theadElement.attributeValue("name").split("\\.")[0] + "']"; Element
 * declareElement = (Element) d.selectSingleNode(getdeclare);
 * 
 * List<Element> ports = declareElement.elements("ownedDataPort");
 * TraverseOwnedPorts4task(modelfilename, ports, idString, "dataport");
 * 
 * _task t = new _task(); t.setName(theadElement.attributeValue("name"));
 * 
 * t.setTaskid(idString); t.setFatherid(fatherid); insert_task(t); } } }
 * 
 * private static String Getfilename(String systemSubcomponentType) { if
 * (systemSubcomponentType != null) { String reg = "(?<=\\s)[A-Za-z0-9]+";
 * Pattern pattern = Pattern.compile(reg); Matcher matcher =
 * pattern.matcher(systemSubcomponentType); ArrayList<String> result = new
 * ArrayList<String>(); while (matcher.find()) { result.add(matcher.group()); }
 * if (result.size() > 0) { return result.get(0) + ".aaxl2"; } } return ""; }
 * 
 * // 解析partition，即处理器的分区 private void partitionResolver(String filepath) throws
 * Exception { Document document = ModelResolver(filepath); String
 * getpartitionString =
 * "//ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedPropertyAssociation[contains(@property,'Binding')]";
 * List<? extends Node> bindings = document.selectNodes(getpartitionString);
 * 
 * for (Node n : bindings) { Element e = (Element) n; Element p1 =
 * e.element("ownedValue").element("ownedValue").element("ownedListElement").
 * element("path"); // 有的binding是绑定在processor上的，有的是绑定在partition上的 //
 * 只找部署在分区上的task，元模型中task是部署在partition上的不是processor上的 if (p1 != null) { // p1 =
 * p1.element("path"); String taskpath =
 * e.element("appliesTo").element("path").attributeValue("namedElement"); String
 * partitionPath = p1.attributeValue("namedElement"); Integer pid = (int)
 * GetID.getId(); AppendID.AppendID(filepath, GetXPath(partitionPath),
 * pid.toString());
 * 
 * Element implElement = (Element)
 * document.selectSingleNode(GetXPath(taskpath));
 * 
 * String decalrepath = "//ownedClassifier[@name='" +
 * implElement.attributeValue("name").split("\\.")[0] + "']"; String taskid =
 * ((Element) document.selectSingleNode(decalrepath)).attributeValue("id");
 * 
 * String rtosid = GetElementID(filepath, n.getParent().getUniquePath());
 * 
 * _partition p = new _partition(); p.setPartitionid(pid); // 部署了哪个rtos
 * p.setRtosid(Integer.valueOf(rtosid)); component comp = new component();
 * comp.setComponentid(pid); comp.setType("partition");
 * comp.setModeltype("aadl"); comp.setName(((Element)
 * document.selectSingleNode(GetXPath(partitionPath))).attributeValue("name"));
 * camArchMapper.insert(comp); ptm.insert(p); // TODO
 * partition作为component，设置task的partitionID _task t = new _task();
 * t.setTaskid(Integer.valueOf(taskid)); t.setPartitionid(pid);
 * _tm.updateByPrimaryKeySelective(t); } } }
 * 
 * private static String GetSysname(String systemSubcomponentType) { if
 * (systemSubcomponentType != null) { String reg = "(?<=#).*\\.[A-Za-z0-9]+";
 * Pattern pattern = Pattern.compile(reg); Matcher matcher =
 * pattern.matcher(systemSubcomponentType); ArrayList<String> result = new
 * ArrayList<String>(); while (matcher.find()) { result.add(matcher.group()); }
 * if (result.size() > 0) { String[] strings = result.get(0).split("\\.");
 * return strings[strings.length - 2] + "." + strings[strings.length - 1]; } }
 * return ""; }
 * 
 * //哪个处理器处理了哪个task就是schedule private void scheduleResolver(String
 * modelfilename) throws Exception { Document document =
 * ModelResolver(modelfilename); String getbindings =
 * "//ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedPropertyAssociation";
 * List<? extends Node> nodes = document.selectNodes(getbindings); for (Node n :
 * nodes) { // 解析deploy关系 Element e = (Element) n; //
 * namedElement存储的是在impl里面声明的组件 if
 * (e.attributeValue("property").contains("Actual_Processor_Binding")) {
 * 
 * String taskid = GetSubCompID(modelfilename,
 * e.element("appliesTo").element("path").attributeValue("namedElement"));
 * 
 * Element sb = (Element)
 * document.selectSingleNode(GetXPath(e.element("ownedValue").element(
 * "ownedValue")
 * .element("ownedListElement").element("path").attributeValue("namedElement")))
 * ; try { // memory是没有虚拟组件的，自然就没有schedule Element sbimplElement = (Element)
 * document .selectSingleNode(GetXPath42layer(sb.attributeValue(
 * "processorSubcomponentType"))); Element vt = (Element) document
 * .selectSingleNode(GetXPath42layer(sbimplElement.element(
 * "ownedVirtualProcessorSubcomponent")
 * .attributeValue("virtualProcessorSubcomponentType")));
 * 
 * String schedulename = vt.attributeValue("name"); Integer i = (int)
 * GetID.getId(); linkpoint l = new linkpoint(); l.setLinkpointid(i);
 * l.setName(schedulename); l.setModeltype("aadl"); portsMapper.insert(l);
 * taskschedule t = new taskschedule(); t.setTaskscheduleid(i);
 * tscmapper.insert(t);
 * 
 * _task t2 = new _task(); t2.setTaskid(Integer.valueOf(taskid));
 * t2.setTaskscheduleid(i); _tm.updateByPrimaryKeySelective(t2); } catch
 * (Exception e2) {
 * 
 * System.out.print(sb.attributeValue("processorSubcomponentType")); } }
 * 
 * //
 * linkpoint的加入存储,task绑定shcedule的id，这里的task已经有了id(前提是确保task在这之前解析了)，要写一个数据库操作获取
 * } }
 * 
 * public void SetSysFileID(String archfilepath, String sysfilepath) throws
 * Exception { Document document = ModelResolver(archfilepath); String getsys =
 * "//ownedPublicSection/ownedClassifier[@xsi:type='aadl2:SystemImplementation']/ownedSystemSubcomponent";
 * List<? extends Node> nodes = document.selectNodes(getsys);
 * 
 * for (Node n : nodes) { String raw = GetSysname(((Element)
 * n).attributeValue("systemSubcomponentType")); String sysname = raw;
 * 
 * String sys =
 * "//ownedClassifier[@xsi:type='aadl2:SystemImplementation' and @name='" +
 * sysname + "']"; if (!sysfilepath.contains(";")) {
 * 
 * document = ModelResolver(sysfilepath); Element e = (Element) n;
 * 
 * AppendID.AppendID(sysfilepath, sys, e.attributeValue("id")); } else {
 * String[] sysfiles = sysfilepath.split(";"); for (String s : sysfiles) {
 * document = ModelResolver(s); Element e = (Element) n;
 * 
 * AppendID.AppendID(s, sys, e.attributeValue("id")); } } } }
 * 
 * // 解析source路径,传递context，跨文件查找 private static String GetName(String
 * modelfilename, String rawpath) throws Exception { Document document =
 * ModelResolver(modelfilename); CharSequence s = "."; if (rawpath.contains(s))
 * {
 * 
 * rawpath = GetXPath(rawpath); } Node node =
 * document.selectSingleNode(rawpath); Element e = (Element) node; if (e !=
 * null) return e.attributeValue("name"); else return ""; }
 * 
 * private static String GetElementID(String modelfilename, String rawpath)
 * throws Exception { Document document = ModelResolver(modelfilename);
 * CharSequence s = "."; if (rawpath.contains(s)) {
 * 
 * rawpath = GetXPath(rawpath); } Node node =
 * document.selectSingleNode(rawpath); Element e = (Element) node; if (e !=
 * null) return e.attributeValue("id"); else return ""; }
 * 
 * //sub指向的是impl，所以要通过name找到id private static String GetSubCompID(String
 * modelfilename, String rawpath) throws Exception { Document document =
 * ModelResolver(modelfilename); CharSequence s = "."; if (rawpath.contains(s))
 * { // sub的路径 rawpath = GetXPath(rawpath); } Node node =
 * document.selectSingleNode(rawpath); Element e = (Element) node; if (e !=
 * null) { String reg = "(?<=@).[A-Za-z0-9\\.]+"; ArrayList<String> result = new
 * ArrayList<String>(); Pattern pattern = Pattern.compile(reg); String s1 = "";
 * if (e.attributeValue("processorSubcomponentType") != null) { s1 =
 * e.attributeValue("processorSubcomponentType"); } else if
 * (e.attributeValue("processSubcomponentType") != null) { s1 =
 * e.attributeValue("processSubcomponentType"); } else { s1 =
 * e.attributeValue("memorySubcomponentType"); } Matcher matcher =
 * pattern.matcher(s1); while (matcher.find()) { result.add(matcher.group()); }
 * for (int j = 1; j < result.size(); j++) { result.set(j,
 * getinc(result.get(j))); } // IMPL是没有id的 String name = ((Element)
 * document.selectSingleNode("//" + result.get(0) + "/" + result.get(1)))
 * .attributeValue("name").split("\\.")[0]; return ((Element)
 * document.selectSingleNode("//ownedClassifier[@name='" + name + "']"))
 * .attributeValue("id"); } else return ""; }
 * 
 * 
 * 根据路径获取ID,只支持三层结构的xpath
 * 
 * private static String GetXPath(String path) { String reg =
 * "(?<=@).[A-Za-z0-9\\.]+"; ArrayList<String> result = new ArrayList<String>();
 * Pattern pattern = Pattern.compile(reg); Matcher matcher =
 * pattern.matcher(path); while (matcher.find()) { result.add(matcher.group());
 * } for (int j = 1; j < result.size(); j++) {
 * 
 * result.set(j, getinc(result.get(j))); } return "//" + result.get(0) + "/" +
 * result.get(1) + "/" + result.get(2); }
 * 
 * private static String GetXPath42layer(String path) { String reg =
 * "(?<=@).[A-Za-z0-9\\.]+"; ArrayList<String> result = new ArrayList<String>();
 * Pattern pattern = Pattern.compile(reg); Matcher matcher =
 * pattern.matcher(path); while (matcher.find()) { result.add(matcher.group());
 * } for (int j = 1; j < result.size(); j++) {
 * 
 * result.set(j, getinc(result.get(j))); } return "//" + result.get(0) + "/" +
 * result.get(1); }
 * 
 * //5层 private static String GetXPath4State(String path) { String reg =
 * "(?<=@).[A-Za-z0-9\\.]+"; ArrayList<String> result = new ArrayList<String>();
 * Pattern pattern = Pattern.compile(reg); Matcher matcher =
 * pattern.matcher(path); while (matcher.find()) { result.add(matcher.group());
 * } for (int j = 1; j < result.size(); j++) {
 * 
 * result.set(j, getinc(result.get(j))); } return "//" + result.get(0) + "/" +
 * result.get(1) + "/" + result.get(2) + "/" + result.get(3) + "/" +
 * result.get(4); }
 * 
 * private static String getinc(String source) { CharSequence cs = "."; if
 * (source.contains(cs)) { String reg4c = "[A-Za-z]+"; String reg4num =
 * "[0-9]+";
 * 
 * Pattern pattern = Pattern.compile(reg4c); Matcher matcher =
 * pattern.matcher(source); List<String> list = new ArrayList<>(); while
 * (matcher.find()) { list.add(matcher.group()); } String c = list.get(0);
 * 
 * pattern = Pattern.compile(reg4num); matcher = pattern.matcher(source); list =
 * new ArrayList<>(); while (matcher.find()) { list.add(matcher.group()); }
 * Integer i = Integer.valueOf(list.get(0)); String num = (++i).toString();
 * 
 * return c + "[" + num + "]"; } else { return source; }
 * 
 * } }
 */