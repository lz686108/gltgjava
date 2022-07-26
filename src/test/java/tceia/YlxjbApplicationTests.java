//package tceia;
//
//import cn.hutool.http.HttpRequest;
//import cn.hutool.http.HttpResponse;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.util.ObjectUtils;
//import sun.net.www.http.HttpClient;
//import tceia.technology.entity.Processstand;
//import tceia.technology.entity.Unconventionality;
//import tceia.technology.mapper.ProcessstandMapper;
//import tceia.technology.mapper.UnconventionalityMapper;
//import tceia.ylxjb.entity.*;
//import tceia.ylxjb.mapper.*;
//
//import java.text.DecimalFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//@SpringBootTest
//class YlxjbApplicationTests {
//
//    @Autowired
//    public LurufMapper lurufMapper;
//    @Autowired
//    public ButvaluMapper butvaluMapper;
//    @Autowired
//    public ProcessstandMapper processstandMapper;
//    @Autowired
//    public UnconerpMapper unconerpMapper;
//    @Autowired
//    public MonthMapper monthMapper;
//    @Autowired
//    public ParseczMapper parseczMapper;
//    @Autowired
//    public JcwyCopy1Mapper jcwyCopy1Mapper;
//    @Autowired
//    public JtgrsMapper jtgrsMapper;
//    @Autowired
//    public GcilmaMapper gcilmaMapper;
//    @Autowired
//    public DbcsMapper dbcsMapper;
//    @Autowired
//    public WymdcwhMapper wymdcwhMapper;
//    @Autowired
//    public JfdcwhCopy1Mapper jfdcwhCopy1Mapper;
//    @Autowired
//    public WymjcMapper wymjcMapper;
//    @Autowired
//    public YmjcMapper ymjcMapper;
//    @Autowired
//    public BgqhsjMapper bgqhsjMapper;
//    @Autowired
//    public JfdcwhMapper jfdcwhMapper;
//    @Autowired
//    public DbcsCopy1Mapper dbcsCopy1Mapper;
//    @Autowired
//    public JtbizhbCopy1Mapper jtbizhbCopy1Mapper;
//    @Autowired
//    public JcwyCopy1Copy1Mapper jcwyCopy1Copy1Mapper;
//    @Autowired
//    public UnconventionalityMapper unconventionalityMapper;
//    @Autowired
//    public VueglGlMapper vueglGlMapper;
//
//    @Test
//    public void eieca() {
//        List<JcwyCopy1Copy1> jcwyCopy1Copy1s = jcwyCopy1Copy1Mapper.selectList(null);
//        System.out.println(jcwyCopy1Copy1s);
//    }
//
//    @Test
//    public void cucieails() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Date date = new Date();
//        String format = simpleDateFormat.format(date);
//        QueryWrapper<JcwyCopy1> jcwyCopy1QueryWrapper = new QueryWrapper<>();
//        jcwyCopy1QueryWrapper.groupBy("version");
//        List<JcwyCopy1> jcwyCopy1s = jcwyCopy1Mapper.selectList(jcwyCopy1QueryWrapper);
//        JcwyCopy1 jcwyCopy1 = jcwyCopy1s.get(jcwyCopy1s.size() - 1);
//        String version = jcwyCopy1.getVersion();
//        QueryWrapper<JcwyCopy1> jcwyCopy1QueryWrapper1 = new QueryWrapper<>();
//        jcwyCopy1QueryWrapper1.eq("version", version);
//        List<JcwyCopy1> jcwyCopy1s1 = jcwyCopy1Mapper.selectList(jcwyCopy1QueryWrapper1);
//        for (int i = 0; i < jcwyCopy1s1.size(); i++) {
//            JcwyCopy1 jcwyCopy11 = new JcwyCopy1();
//            jcwyCopy11.setMaterialName(jcwyCopy1s1.get(i).getMaterialName());
//            jcwyCopy11.setDistributorName(jcwyCopy1s1.get(i).getDistributorName());
//            jcwyCopy11.setGsdgils(jcwyCopy1s1.get(i).getGsdgils());
//            jcwyCopy11.setSterilise(jcwyCopy1s1.get(i).getSterilise());
//            jcwyCopy11.setContractPrice(jcwyCopy1s1.get(i).getContractPrice());
//            jcwyCopy11.setMonthAmount(jcwyCopy1s1.get(i).getMonthAmount());
//            jcwyCopy11.setJssf(jcwyCopy1s1.get(i).getJssf());
//            jcwyCopy11.setJsfm(jcwyCopy1s1.get(i).getJsfm());
//            jcwyCopy11.setVersion(format);
//            jcwyCopy11.setJzzaniu(jcwyCopy1s1.get(i).getJzzaniu());
//            jcwyCopy11.setZltj(jcwyCopy1s1.get(i).getZltj());
//            jcwyCopy11.setKdl(jcwyCopy1s1.get(i).getKdl());
//            jcwyCopy1Mapper.insert(jcwyCopy11);
//        }
//        List<JcwyCopy1Copy1> sc = selecttocopycopy(format, null, null);
//        for (int i = 0; i < sc.size(); i++) {
//            sc.get(i).setVersionrs(format);
//            jcwyCopy1Copy1Mapper.insert(sc.get(i));
//        }
//    }
//
//    @Test
//    void sssdsdsdsd() {
//        List<Processstand> processstands = processstandMapper.selectList(null);
//        System.out.println(processstands);
//    }
//
//    @Test
//    void contextLoads() {
//        Luruf luruf = new Luruf();
//        luruf.setContractPrice("4");
//        int insert = lurufMapper.insert(luruf);
//        List<Luruf> lurufs = lurufMapper.selectList(null);
//        System.out.println(lurufs);
//    }
//
//    @Test
//    void sss() {
//        QueryWrapper<Butvalu> butvaluQueryWrapper = new QueryWrapper<>();
//        butvaluQueryWrapper.eq("attribute_name", "料种");
//        List<Butvalu> butvalus = butvaluMapper.selectList(butvaluQueryWrapper);
//        System.out.println(butvalus);
//    }
//
//    @Test
//    void ddasda() {
//        QueryWrapper<Luruf> lw = new QueryWrapper<>();
//        lw.groupBy("material_name", "distributor_name", "sterilise");
//        List<Luruf> lurufs = lurufMapper.selectList(lw);
//        System.out.println(lurufs);
//    }
//
//    @Test
//    void dodod() {
//        String ss = "";
//        Double aDouble = Double.valueOf(ss);
//        System.out.println(aDouble);
//    }
//
//    @Test
//    void mmmmmm() {
//        Date date = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String format1 = format.format(date);
//        Calendar instance = Calendar.getInstance();
//        instance.set(Calendar.YEAR, Integer.parseInt(format1.substring(0, 4)));
//        instance.set(Calendar.MONTH, Integer.parseInt(format1.substring(5, 7)));
//        instance.set(Calendar.DAY_OF_MONTH, 1);
//        instance.add(Calendar.MONTH, -1);
//        String format2 = format.format(instance.getTime());
//        System.out.println(format2);
//    }
//
//    @Test
//    void llllllllll() {
//        Calendar instance = Calendar.getInstance();
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        instance.setTime(new Date());
//        instance.add(Calendar.YEAR, -1);
//        Date time = instance.getTime();
//        String format1 = format.format(time);
//        System.out.println(format1);
//        instance.add(Calendar.YEAR, -1);
//        Date time1 = instance.getTime();
//        System.out.println(format.format(time1));
//        instance.add(Calendar.YEAR, -1);
//        Date time2 = instance.getTime();
//        System.out.println(format.format(time2));
//    }
//
//    @Test
//    void ikikkikki() {
//        Calendar cal = Calendar.getInstance();
//        //设置年份
//        cal.set(Calendar.YEAR, 2021);
//        //设置月份
//        cal.set(Calendar.MONTH, 1 - 1);
//        //获取某月最小天数
//        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
//        //设置日历中月份的最小天数
//        cal.set(Calendar.DAY_OF_MONTH, firstDay);
//        //格式化日期
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String firstDayOfMonth = sdf.format(cal.getTime());
//        System.out.println(sdf.format(cal.getTime()));
//        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//        cal.set(Calendar.DAY_OF_MONTH, lastDay);
//        System.out.println(sdf.format(cal.getTime()));
//    }
//
//    @Test
//    void kiukiukii() {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
//        ArrayList<String> as = new ArrayList<>();
//        for (int i = 0; i < 24; i++) {
//            Calendar c = Calendar.getInstance();
//            c.setTime(new Date());
//            c.add(Calendar.MONTH, -i);
//            String format = df.format(c.getTime());
//            as.add(format);
//        }
//        System.out.println(as);
//    }
//
//
//    @Test
//    void tample() {
//        String daa = "2022-01-01";
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        calendar.set(Calendar.YEAR, Integer.parseInt(daa.substring(0, 4)));
//        calendar.set(Calendar.MONTH, Integer.parseInt(daa.substring(5, 7)) - 1);
//        calendar.set(Calendar.DATE, Integer.parseInt(daa.substring(8, 10)));
//        calendar.add(Calendar.DATE, -7);
//        Date dateTime = calendar.getTime();
//        String daytose = sdf.format(dateTime);
//        System.out.println(daytose);
//    }
//
//    @Test
//    void njjnn() {
//        Calendar cal = Calendar.getInstance();
//        //设置年份
//        cal.set(Calendar.YEAR, Integer.parseInt("2022"));
//        //设置月份
//        cal.set(Calendar.MONTH, Integer.parseInt("01") - 1);
//        //获取某月最小天数
//        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
//        //设置日历中月份的最小天数
//        cal.set(Calendar.DAY_OF_MONTH, firstDay);
//        //格式化日期
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String firstDayOfMonth = sdf.format(cal.getTime());
//        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
//        cal.set(Calendar.DAY_OF_MONTH, lastDay);
//        String lastDayOfMonth = sdf.format(cal.getTime());
//        System.out.println(firstDayOfMonth);
//    }
//
//    @Test
//    void gmacilers() {
//        String a[] = new String[6];
//        String b[] = new String[6];
//        for (int i = 0; i < a.length; i++) {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            //获取前月的第一天
//            Calendar cal_1 = Calendar.getInstance();//获取当前日期
//            cal_1.add(Calendar.MONTH, -i);
//            cal_1.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
//            String firstDay = format.format(cal_1.getTime());
//            a[i] = firstDay;
//            //获取前月的最后一天
//            //获取当前月第一天：
//            Calendar c = Calendar.getInstance();
//            c.add(Calendar.MONTH, -i + 1);
//            c.set(Calendar.DAY_OF_MONTH, 0);//设置为1号,当前日期既为本月第一天
//            String lastDay = format.format(c.getTime());
//            b[i] = lastDay;
//        }
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
//        for (int i = 0; i < b.length; i++) {
//            System.out.println(b[i]);
//        }
//    }
//
//    @Test
//    void gimaile() {
//        QueryWrapper<JcwyCopy1> jw = new QueryWrapper<>();
//        jw.between("version", "2022-02-07 ", "2022-02-18");
//        jw.select("Distinct distributor_name,contract_price,gsdgils,jssf,jsfm,version");
//        jw.orderByDesc("version");
//        List<JcwyCopy1> jcwyCopy1s = jcwyCopy1Mapper.selectList(jw);
//        JcwyCopy1 jcwyCopy1 = jcwyCopy1s.get(0);
//        System.out.println(jcwyCopy1);
//    }
//
//    @Test
//    void gimaile1() {
//        QueryWrapper<JcwyCopy1> jqw = new QueryWrapper<>();
//        jqw.select("distinct distributor_name");
//        jqw.between("version", "2022-02-14", "2022-02-18");
//        List<JcwyCopy1> jcwyCopy1s = jcwyCopy1Mapper.selectList(jqw);
//        for (int i = 0; i < jcwyCopy1s.size(); i++) {
//            JcwyCopy1 jcwyCopy1 = new JcwyCopy1();
//            QueryWrapper<JcwyCopy1> jqw1 = new QueryWrapper<>();
//            jqw1.eq("distributor_name", jcwyCopy1s.get(i).getDistributorName());
//            jqw1.orderByDesc("version");
//            List<JcwyCopy1> jcwyCopy1s2 = jcwyCopy1Mapper.selectList(jqw1);
//            System.out.println(jcwyCopy1s2.get(0));
//        }
//    }
//
//    @Test
//    void selectdcchangjia() {
//        QueryWrapper<VueglGl> vueglGlQueryWrapper = new QueryWrapper<>();
//        vueglGlQueryWrapper.groupBy("lhnubm", "bbh", "changjia");
//        List<VueglGl> vueglGls = vueglGlMapper.selectList(vueglGlQueryWrapper);
//        System.out.println(vueglGls);
//    }
//
//    @Test
//    void gciails() {
//        String a = "2022-01-14 16：58";
//        String b = "2022-02-18 12：30";
//        Date date2 = java.sql.Date.valueOf(b);
//        Date date1 = java.sql.Date.valueOf(a);
//        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
//        System.out.println("1987-01-01 与 2010-01-01 相隔 " + Integer.parseInt(String.valueOf(days)) + " 天");
//    }
//
//    @Test
//    void oli() throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date d1 = null;
//        d1 = sdf.parse(String.valueOf(new Date("2022-01-31T16:00:00.000Z")));
//        Date d2 = null;
//        d2 = sdf.parse("2022-02-22");
//        System.out.println(daysBetween(d1, d2));
//    }
//
//    @Test
//    void utinacil() throws ParseException {
//        String a = "2022-01-31T16:00:00.000Z";
//        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
//        // Date format = sd.parse(sd1.format(sd1.parse(a)));
//        Date a1 = sd1.parse("2022-01-14");
//
//        int i = daysBetween(a1, sd1.parse(a));
//        System.out.println(i);
//    }
//
//    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        smdate = sdf.parse(sdf.format(smdate));
//        bdate = sdf.parse(sdf.format(bdate));
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(smdate);
//        long time1 = cal.getTimeInMillis();
//        cal.setTime(bdate);
//        long time2 = cal.getTimeInMillis();
//        long between_days = (time2 - time1) / (1000 * 3600 * 24);
//        return Integer.parseInt(String.valueOf(between_days));
//    }
//
//    @Test
//    public void tigals() {
//        QueryWrapper<Jtgrs> jtgrsnes = new QueryWrapper<>();
//        jtgrsnes.between("jjrq", "2022-03-01", "2022-03-09");
//        jtgrsnes.ne("sjzl", "");
//        jtgrsnes.eq("gysmc", "乌海市泰鑫实业有限公司");
//        jtgrsnes.groupBy("ph");
//        jtgrsnes.select("AVG(Ad)", "AVG(Vdaf)", "AVG(Fcad)", "AVG(St_d)", "AVG(M25)", "AVG(CRI)", "AVG(CSR)", "AVG(Mt)", "AVG(Mt)", "SUM(sjzl)", "ph");
//        List<Map<String, Object>> maps = jtgrsMapper.selectMaps(jtgrsnes);
//        Map<String, Object> stringObjectMap = maps.get(0);
//        System.out.println(stringObjectMap.get("AVG(Ad)"));
//        System.out.println(maps);
//    }
//
//    @Test
//    public void gcila() {
//        QueryWrapper<Gcilma> jtgrsnes = new QueryWrapper<>();
//        jtgrsnes.between("jjrq", "2022-03-01", "2022-03-10");
//        jtgrsnes.ne("sjzl", "");
//        jtgrsnes.eq("gysmc", "内蒙古力源煤炭有限公司");
//        jtgrsnes.groupBy("ph");
//        jtgrsnes.select("AVG(case when ad != '' and ad is not null then ad end) as ad ",
//                "AVG(case when fcd != '' and fcd is not null then fcd end) as fcd",
//                "AVG(case when mad != '' and mad is not null then mad end) as mad",
//                "AVG(case when mt != '' and mt is not null then mt end) as mt",
//                "AVG(case when qgr_d != '' and qgr_d is not null then qgr_d end) as qgr_d",
//                "AVG(case when qnet_v_ar != '' and qnet_v_ar is not null then qnet_v_ar end) as qnet_v_ar",
//                "AVG(case when st_d != '' and st_d is not null then st_d end) as st_d",
//                "AVG(case when vdaf != '' and vdaf is not null then vdaf end) as vdaf",
//                "sum(sjzl)", "ph"
//        );
//        List<Map<String, Object>> maps = gcilmaMapper.selectMaps(jtgrsnes);
//        Map<String, Object> stringObjectMap = maps.get(0);
//        System.out.println(maps);
//    }
//
//    @Test
//    public void stial() {
//        QueryWrapper<Jtgrs> jtgrsQueryWrapper = new QueryWrapper<>();
//        jtgrsQueryWrapper.between("jjrq", "2022-03-32", "2022-03-32");
//        jtgrsQueryWrapper.eq("gysmc", "山西闻祥国际贸易有限公司");
//        jtgrsQueryWrapper.eq("fhdd", "");
//        jtgrsQueryWrapper.eq("ylmc", "一级焦炭").or().eq("ylmc", "二级焦炭").or().eq("ylmc", "三级焦炭").or().eq("ylmc", "准一级焦炭");
//        jtgrsMapper.selectList(jtgrsQueryWrapper);
//    }
//
//    @Test
//    public void jiurgk() {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
//        String format = df.format(new Date());
//        System.out.println(format);// new Date()为获取当前系统时间
//    }
//
//    @Test
//    void kmkerk() {
//        QueryWrapper<Dbcs> dbcsQueryWrapper1 = new QueryWrapper<>();
//        dbcsQueryWrapper1.groupBy("version");
//        dbcsQueryWrapper1.orderByDesc("version");
//        dbcsQueryWrapper1.last("limit 1");
//        Dbcs dbcs1 = dbcsMapper.selectList(dbcsQueryWrapper1).get(0);
//        QueryWrapper<Dbcs> dbcsQueryWrapper2 = new QueryWrapper<>();
//        dbcsQueryWrapper2.eq("version", dbcs1.getVersion());
//        List<Dbcs> dbcs2 = dbcsMapper.selectList(dbcsQueryWrapper2);
//        HashMap<String, String> sgm = new HashMap<>();
//        for (int i = 0; i < dbcs2.size(); i++) {
//            sgm.put(dbcs2.get(i).getGysmc(), dbcs2.get(i).getPb());
//        }
//        System.out.println(sgm);
//    }
//
//    @Test
//    void grek() {
//        List<Wymdcwh> wymdcwhs = wymdcwhMapper.selectList(null);
//        String a = "";
//        for (int i = 0; i < wymdcwhs.size(); i++) {
//            a = a + "," + wymdcwhs.get(i).getId();
//        }
//        String substring = a.substring(1);
//        substring = "[" + substring + "]";
//        System.out.println(substring);
//    }
//
//    @Test
//    void cucrs() {
//        QueryWrapper<JfdcwhCopy1> jf = new QueryWrapper<>();
//        jf.orderByDesc("version");
//        jf.select("DISTINCT version");
//        jf.last("limit 20");
//        //jf.select("limit 20");
//        jfdcwhCopy1Mapper.selectList(jf);
//    }
//
//    @Test
//    public void groupatedsqi() {
//        QueryWrapper<Wymdcwh> wqw = new QueryWrapper<>();
//        wqw.eq("rllx", "无烟煤");
//        List<Wymdcwh> wymdcwhs = wymdcwhMapper.selectList(wqw);
//        String a = "";
//        for (int i = 0; i < wymdcwhs.size(); i++) {
//            a = a + "," + wymdcwhs.get(i).getId();
//        }
//        String substring = a.substring(1);
//        String idrs = "[" + substring + "]";
//        String ourbbhar = selectjcdisallarl(idrs);
//        Map<String, List<Object>> routerairnw = routerairnw(ourbbhar);
//    }
//
//    public String selectjcdisallarl(String idrs) {
//        DecimalFormat df = new DecimalFormat("0.00");
//        //查询焦粉和无烟煤的固体燃耗
//        QueryWrapper<Butvalu> butvaluQueryWrapper = new QueryWrapper<>();
//        butvaluQueryWrapper.eq("attribute_name", "无烟煤固体燃耗").or().eq("attribute_name", "焦粉固体燃耗");
//        List<Butvalu> butvalus = butvaluMapper.selectList(butvaluQueryWrapper);
//        //无烟煤
//        String wymrh = "";
//        //焦粉
//        String jfrh = "";
//        if (butvalus.get(0).getAttributeName().equals("焦粉固体燃耗")) {
//            jfrh = butvalus.get(0).getPropertyValue();
//            wymrh = butvalus.get(1).getPropertyValue();
//        } else {
//            jfrh = butvalus.get(1).getPropertyValue();
//            wymrh = butvalus.get(0).getPropertyValue();
//        }
//        //获取当前时间
//        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
//        String format = dfs.format(new Date());
//        //处理传过来的id数组
//        String replace = idrs.replace("[", "").replace("]", "");
//        String[] split = replace.split(",");
//        //查询焦粉信息
//        List<Jfdcwh> jfdcwhs = jfdcwhMapper.selectList(null);
//        Jfdcwh jfdcwh = jfdcwhs.get(0);
//        JfdcwhCopy1 jfdcwhCopy11 = new JfdcwhCopy1();
//        jfdcwhCopy11.setAd(jfdcwh.getAd());
//        jfdcwhCopy11.setStd(jfdcwh.getStd());
//        jfdcwhCopy11.setQgrd(jfdcwh.getQgrd());
//        jfdcwhCopy11.setVdaf(jfdcwh.getVdaf());
//        jfdcwhCopy11.setFcd(jfdcwh.getFcd());
//        jfdcwhCopy11.setMt(jfdcwh.getMt());
//        jfdcwhCopy11.setMad(jfdcwh.getMad());
//        jfdcwhCopy11.setCcjg(jfdcwh.getCcjg());
//        jfdcwhCopy11.setYfjg(jfdcwh.getYfjg());
//        jfdcwhCopy11.setDcjg(jfdcwh.getDcjg());
//        jfdcwhCopy11.setFkfs(jfdcwh.getFkfs());
//        jfdcwhCopy11.setJssf(jfdcwh.getJssf());
//        jfdcwhCopy11.setBhsjg(jfdcwh.getBhsjg());
//        jfdcwhCopy11.setSjgtdh(jfdcwh.getSjgtdh());
//        jfdcwhCopy11.setDsrhdwcb(jfdcwh.getDsrhdwcb());
//        jfdcwhCopy11.setGysmc(jfdcwh.getGysmc());
//        jfdcwhCopy11.setVersion(format);
//        jfdcwhCopy1Mapper.insert(jfdcwhCopy11);
//        for (int i = 0; i < split.length; i++) {
//            JfdcwhCopy1 jfdcwhCopy1 = new JfdcwhCopy1();
//            QueryWrapper<Wymdcwh> jfdcwhQueryWrapper = new QueryWrapper<>();
//            jfdcwhQueryWrapper.eq("id", split[i]);
//            List<Wymdcwh> jfdcwhs1 = wymdcwhMapper.selectList(jfdcwhQueryWrapper);
//            Wymdcwh wymdcwh = jfdcwhs1.get(0);
//            jfdcwhCopy1.setGysmc(wymdcwh.getDistributorName());
//            jfdcwhCopy1.setCcjg(wymdcwh.getContractPrice());
//            jfdcwhCopy1.setYfjg(wymdcwh.getJsfm());
//            jfdcwhCopy1.setFkfs(wymdcwh.getSterilise());
//            jfdcwhCopy1.setJssf(wymdcwh.getJssf());
//            jfdcwhCopy1.setSjgtdh(wymrh);
//            jfdcwhCopy1.setVersion(format);
//            jfdcwhCopy1.setDcjg(df.format(Double.valueOf(jfdcwhCopy1.getCcjg()) + Double.valueOf(jfdcwhCopy1.getYfjg())));
//            if (wymdcwh.getSterilise().equals("承兑")) {
//                //出厂价格/1.02/1.13/（100-结算水分）/100+运费价格/1.09
//                jfdcwhCopy1.setBhsjg(df.format(Double.valueOf(jfdcwhCopy1.getCcjg()) / 1.02 / 1.13 / ((100 - Double.valueOf(jfdcwhCopy1.getJssf())) / 100) +
//                        (Double.valueOf(jfdcwhCopy1.getYfjg())) / 1.09));
//            } else {
//                //出厂价格/1.13/（100-结算水分）/100+运费价格/1.09
//                jfdcwhCopy1.setBhsjg(df.format(Double.valueOf(jfdcwhCopy1.getCcjg()) / 1.13 / ((100 - Double.valueOf(jfdcwhCopy1.getJssf())) / 100) +
//                        (Double.valueOf(jfdcwhCopy1.getYfjg())) / 1.09));
//            }
//            //吨烧燃耗单位成本
//            jfdcwhCopy1.setDsrhdwcb(df.format(Double.valueOf(jfdcwhCopy1.getBhsjg()) / 1000 * Double.valueOf(jfdcwhCopy1.getSjgtdh())));
//            QueryWrapper<Wymjc> jtwq = new QueryWrapper<>();
//            jtwq.eq("gysmc", jfdcwhCopy1.getGysmc());
//            List<Wymjc> jtbizhbCopy1s = wymjcMapper.selectList(jtwq);
//            Wymjc jtbizhbCopy1 = jtbizhbCopy1s.get(0);
//            jfdcwhCopy1.setAd(df.format(Double.valueOf(jtbizhbCopy1.getAd())));
//            jfdcwhCopy1.setStd(df.format(Double.valueOf(jtbizhbCopy1.getStD())));
//            jfdcwhCopy1.setQgrd(df.format(Double.valueOf(jtbizhbCopy1.getQgrD())));
//            jfdcwhCopy1.setVdaf(df.format(Double.valueOf(jtbizhbCopy1.getVdaf())));
//            jfdcwhCopy1.setFcd(df.format(Double.valueOf(jtbizhbCopy1.getFcd())));
//            jfdcwhCopy1.setMt(df.format(Double.valueOf(jtbizhbCopy1.getMt())));
//            jfdcwhCopy1.setMad(df.format(Double.valueOf(jtbizhbCopy1.getMad())));
//            Map<String, String> shm = new HashMap<>();
//            HashMap<String, String> jsqtpjz = jsqtpjzwym(jfdcwhCopy1.getGysmc(), format, shm);
//            if (jsqtpjz.containsKey("Ad")) {
//                jfdcwhCopy1.setAd(df.format(Double.valueOf(jsqtpjz.get("Ad"))));
//            }
//            if (jsqtpjz.containsKey("Vdaf")) {
//                jfdcwhCopy1.setVdaf(df.format(Double.valueOf(jsqtpjz.get("Vdaf"))));
//            }
//            if (jsqtpjz.containsKey("Fcd")) {
//                jfdcwhCopy1.setFcd(df.format(Double.valueOf(jsqtpjz.get("Fcd"))));
//            }
//            if (jsqtpjz.containsKey("Mad")) {
//                jfdcwhCopy1.setMad(df.format(Double.valueOf(jsqtpjz.get("Mad"))));
//            }
//            if (jsqtpjz.containsKey("Mt")) {
//                jfdcwhCopy1.setMt(df.format(Double.valueOf(jsqtpjz.get("Mt"))));
//            }
//            if (jsqtpjz.containsKey("qgrd")) {
//                jfdcwhCopy1.setQgrd(df.format(Double.valueOf(jsqtpjz.get("qgrd"))));
//            }
//            if (jsqtpjz.containsKey("Std")) {
//                jfdcwhCopy1.setStd(df.format(Double.valueOf(jsqtpjz.get("Std"))));
//            }
//            if (jsqtpjz.containsKey("vdaf")) {
//                jfdcwhCopy1.setVdaf(df.format(Double.valueOf(jsqtpjz.get("vdaf"))));
//            }
//            jfdcwhCopy1Mapper.insert(jfdcwhCopy1);
//        }
//        return format;
//    }
//
//    public Map<String, List<Object>> routerairnw(String ourbbhar) {
//        HashMap<String, List<Object>> stringListHashMap = new HashMap<>();
//        //默认用上一个版本的配比 变更前
//        QueryWrapper<Dbcs> dbcsQueryWrapper1 = new QueryWrapper<>();
//        dbcsQueryWrapper1.groupBy("version");
//        dbcsQueryWrapper1.orderByDesc("version");
//        dbcsQueryWrapper1.last("limit 1");
//        Dbcs dbcs1 = dbcsMapper.selectList(dbcsQueryWrapper1).get(0);
//        QueryWrapper<Dbcs> dbcsQueryWrapper2 = new QueryWrapper<>();
//        dbcsQueryWrapper2.eq("version", dbcs1.getVersion());
//        List<Dbcs> dbcs2 = dbcsMapper.selectList(dbcsQueryWrapper2);
//        HashMap<String, String> sgm = new HashMap<>();
//        for (int i = 0; i < dbcs2.size(); i++) {
//            sgm.put(dbcs2.get(i).getGysmc(), dbcs2.get(i).getPb());
//        }
//        //查询烟煤和无烟煤都在一起的表数据
//        List<Wymdcwh> wymdcwhs = wymdcwhMapper.selectList(null);
//        DecimalFormat df = new DecimalFormat("0.00");
//        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
//        for (int i = 0; i < wymdcwhs.size(); i++) {
//            //对比测算过上面表的对象
//            Dbcs dbcs = new Dbcs();
//            dbcs.setLx(wymdcwhs.get(i).getRllx());
//            dbcs.setGysmc(wymdcwhs.get(i).getDistributorName());
//            dbcs.setFkfs(wymdcwhs.get(i).getSterilise());
//            dbcs.setCcjg(wymdcwhs.get(i).getContractPrice());
//            dbcs.setJssf(wymdcwhs.get(i).getJssf());
//            dbcs.setYfjg(wymdcwhs.get(i).getJsfm());
//            dbcs.setDcjg(df.format(Double.valueOf(dbcs.getCcjg()) + Double.valueOf(dbcs.getYfjg())));
//            //不含税价格 出厂价格/1.13/（100-结算水分）/100+运费价格/1.09
//            if (wymdcwhs.get(i).getSterilise().equals("承兑")) {
//                dbcs.setBhsjg(df.format(Double.valueOf(dbcs.getCcjg()) / 1.02 / 1.13 / ((100 - Double.valueOf(dbcs.getJssf())) / 100) +
//                        (Double.valueOf(dbcs.getYfjg())) / 1.09));
//            } else {
//                dbcs.setBhsjg(df.format(Double.valueOf(dbcs.getCcjg()) / 1.13 / ((100 - Double.valueOf(dbcs.getJssf())) / 100) +
//                        (Double.valueOf(dbcs.getYfjg())) / 1.09));
//            }
//            if (dbcs.getLx().equals("无烟煤")) {
//                //无烟煤基础数据
//                QueryWrapper<Wymjc> jtwq = new QueryWrapper<>();
//                jtwq.eq("gysmc", dbcs.getGysmc());
//                List<Wymjc> jtbizhbCopy1s = wymjcMapper.selectList(jtwq);
//                Wymjc jtbizhbCopy1 = jtbizhbCopy1s.get(0);
//                dbcs.setAd(df.format(Double.valueOf(jtbizhbCopy1.getAd())));
//                dbcs.setStd(df.format(Double.valueOf(jtbizhbCopy1.getStD())));
//                dbcs.setQgrd(df.format(Double.valueOf(jtbizhbCopy1.getQgrD())));
//                dbcs.setVdaf(df.format(Double.valueOf(jtbizhbCopy1.getVdaf())));
//                dbcs.setFcd(df.format(Double.valueOf(jtbizhbCopy1.getFcd())));
//                dbcs.setMt(df.format(Double.valueOf(jtbizhbCopy1.getMt())));
//                dbcs.setMad(df.format(Double.valueOf(jtbizhbCopy1.getMad())));
//            } else {
//                //无烟煤基础数据
//                QueryWrapper<Ymjc> jtwq = new QueryWrapper<>();
//                jtwq.eq("gysmc", dbcs.getGysmc());
//                List<Ymjc> jtbizhbCopy1s = ymjcMapper.selectList(jtwq);
//                Ymjc jtbizhbCopy1 = jtbizhbCopy1s.get(0);
//                dbcs.setAd(df.format(Double.valueOf(jtbizhbCopy1.getAd())));
//                dbcs.setStd(df.format(Double.valueOf(jtbizhbCopy1.getStD())));
//                dbcs.setQgrd(df.format(Double.valueOf(jtbizhbCopy1.getQgrD())));
//                dbcs.setVdaf(df.format(Double.valueOf(jtbizhbCopy1.getVdaf())));
//                dbcs.setFcd(df.format(Double.valueOf(jtbizhbCopy1.getFcd())));
//                dbcs.setMt(df.format(Double.valueOf(jtbizhbCopy1.getMt())));
//                dbcs.setMad(df.format(Double.valueOf(jtbizhbCopy1.getMad())));
//            }
//            HashMap<String, String> shm = new HashMap<>();
//            HashMap<String, String> jsqtpjz = jsqtpjzwym(dbcs.getGysmc(), ourbbhar, shm);
//            if (jsqtpjz.containsKey("Ad")) {
//                dbcs.setAd(df.format(Double.valueOf(jsqtpjz.get("Ad"))));
//            }
//            if (jsqtpjz.containsKey("Vdaf")) {
//                dbcs.setVdaf(df.format(Double.valueOf(jsqtpjz.get("Vdaf"))));
//            }
//            if (jsqtpjz.containsKey("Fcd")) {
//                dbcs.setFcd(df.format(Double.valueOf(jsqtpjz.get("Fcd"))));
//            }
//            if (jsqtpjz.containsKey("Mad")) {
//                dbcs.setMad(df.format(Double.valueOf(jsqtpjz.get("Mad"))));
//            }
//            if (jsqtpjz.containsKey("Mt")) {
//                dbcs.setMt(df.format(Double.valueOf(jsqtpjz.get("Mt"))));
//            }
//            if (jsqtpjz.containsKey("qgrd")) {
//                dbcs.setQgrd(df.format(Double.valueOf(jsqtpjz.get("qgrd"))));
//            }
//            if (jsqtpjz.containsKey("Std")) {
//                dbcs.setStd(df.format(Double.valueOf(jsqtpjz.get("Std"))));
//            }
//            if (jsqtpjz.containsKey("vdaf")) {
//                dbcs.setVdaf(df.format(Double.valueOf(jsqtpjz.get("vdaf"))));
//            }
//            //无烟煤有效热量 9400*FCd-2800*Ad-20000*St,d
//            if (dbcs.getLx().equals("无烟煤")) {
//                dbcs.setYxrl(df.format(9400 * Double.valueOf(dbcs.getFcd()) - 2800 * Double.valueOf(dbcs.getAd())
//                        - 20000 * Double.valueOf(dbcs.getStd())));
//            } else {
//                dbcs.setYxrl(df.format(8400 * Double.valueOf(dbcs.getFcd()) - 2800 * Double.valueOf(dbcs.getAd())
//                        - 20000 * Double.valueOf(dbcs.getStd())));
//            }
//            //单位有效热量成本 不含税价格/有效热量
//            dbcs.setYxrcb(decimalFormat.format(Double.valueOf(dbcs.getBhsjg()) / Double.valueOf(dbcs.getYxrl())));
//            dbcs.setPb(ObjectUtils.isEmpty(sgm.get(dbcs.getGysmc())) ? "0" : sgm.get(dbcs.getGysmc()));
//            dbcs.setVersion(ourbbhar);
//            dbcsMapper.insert(dbcs);
//        }
//        QueryWrapper<Dbcs> dbcsQueryWrapper = new QueryWrapper<>();
//        dbcsQueryWrapper.eq("version", ourbbhar);
//        List<Dbcs> dbcs = dbcsMapper.selectList(dbcsQueryWrapper);
//        //基准值信息
//        Map<String, String> csujzz = csujzz();
//        Bgqhsj bgqhsj = new Bgqhsj();
//        //变更前有效热量
//        Double bgqyxrl = 0.0;
//        //变更前不含税价格
//        Double bgqbhsjg = 0.0;
//        //变更前置换比
//        Double bgqzhb = 0.0;
//        //变更后有效热量
//        Double bghyxrl = 0.0;
//        //变更后不含税价格
//        Double bghbhsjg = 0.0;
//        //变更后置换比
//        Double bghzhb = 0.0;
//        for (int i = 0; i < dbcs.size(); i++) {
//            bgqyxrl = bgqyxrl + Double.valueOf(dbcs.get(i).getYxrl()) * Double.valueOf(dbcs.get(i).getPb()) / 100;
//            bgqbhsjg = bgqbhsjg + Double.valueOf(dbcs.get(i).getBhsjg()) * Double.valueOf(dbcs.get(i).getPb()) / 100;
//        }
//        bgqhsj.setBgqyxrl(df.format(bgqyxrl));
//        bgqhsj.setBgqbhsjg(df.format(bgqbhsjg));
//        bgqhsj.setBgqzhb(df.format(bgqyxrl / Double.valueOf(csujzz.get("jtyxrl"))));
//        List<DbcsCopy1> routerairnwh = routerairnwh(ourbbhar);
//        for (int i = 0; i < routerairnwh.size(); i++) {
//            bghyxrl = bghyxrl + Double.valueOf(routerairnwh.get(i).getYxrl()) * Double.valueOf(routerairnwh.get(i).getPb()) / 100;
//            bghbhsjg = bghbhsjg + Double.valueOf(routerairnwh.get(i).getBhsjg()) * Double.valueOf(routerairnwh.get(i).getPb()) / 100;
//        }
//        bgqhsj.setBghyxrl(df.format(bghyxrl));
//        bgqhsj.setBghbhsjg(df.format(bghbhsjg));
//        bgqhsj.setBghzhb(df.format(bghyxrl / Double.valueOf(csujzz.get("jtyxrl"))));
//        bgqhsj.setTscb(df.format((bghbhsjg - bgqbhsjg) * Double.valueOf(csujzz.get("mby")) / 1000 - (bghzhb - bgqzhb) * 0.7 * Double.valueOf(csujzz.get("mby")) / 1000 * Double.valueOf(csujzz.get("jtjg"))));
//        bgqhsj.setVersion(ourbbhar);
//        bgqhsjMapper.insert(bgqhsj);
//        QueryWrapper<Bgqhsj> bgqhsjQueryWrapper = new QueryWrapper<>();
//        bgqhsjQueryWrapper.eq("version", ourbbhar);
//        Bgqhsj bgqhsj1 = bgqhsjMapper.selectList(bgqhsjQueryWrapper).get(0);
//        stringListHashMap.put("bgq", Collections.singletonList(dbcs));
//        stringListHashMap.put("bgh", Collections.singletonList(routerairnwh));
//        stringListHashMap.put("bgqhsjx", Collections.singletonList(bgqhsj1));
//        //箭头指向
//        //先判断but表是否有当前版本数据
//        QueryWrapper<Butvalu> butvaluQueryWrapper = new QueryWrapper<>();
//        butvaluQueryWrapper.eq("attribute_name", ourbbhar);
//        List<Butvalu> butvalus = butvaluMapper.selectList(butvaluQueryWrapper);
//        if (ObjectUtils.isEmpty(butvalus)) {
//            //变更前无烟煤配比
//            Double bgqwympb = 0.0;
//            //变更后无烟煤配比
//            Double bghwympb = 0.0;
//            for (int i = 0; i < dbcs.size(); i++) {
//                if (dbcs.get(i).getLx().equals("无烟煤")) {
//                    bgqwympb = bgqwympb + Double.valueOf(dbcs.get(i).getPb());
//                }
//            }
//            for (int i = 0; i < routerairnwh.size(); i++) {
//                if (routerairnwh.get(i).getLx().equals("无烟煤")) {
//                    bghwympb = bghwympb + Double.valueOf(routerairnwh.get(i).getPb());
//                }
//            }
//            Butvalu butvalu = new Butvalu();
//            butvalu.setAttributeName(ourbbhar);
//            if (Double.valueOf(bgqhsj.getTscb()) >= 0) {
//                if (bgqwympb > bghwympb) {
//                    butvalu.setPropertyValue("无烟煤");
//                } else {
//                    butvalu.setPropertyValue("烟煤");
//                }
//            } else {
//                if (bgqwympb > bghwympb) {
//                    butvalu.setPropertyValue("烟煤");
//                } else {
//                    butvalu.setPropertyValue("无烟煤");
//                }
//            }
//            butvaluMapper.insert(butvalu);
//        } else {
//            QueryWrapper<Butvalu> butvaluQueryWrapper1 = new QueryWrapper<>();
//            butvaluQueryWrapper1.eq("attribute_name", ourbbhar);
//            //变更前无烟煤配比
//            Double bgqwympb = 0.0;
//            //变更后无烟煤配比
//            Double bghwympb = 0.0;
//            for (int i = 0; i < dbcs.size(); i++) {
//                if (dbcs.get(i).getLx().equals("无烟煤")) {
//                    bgqwympb = bgqwympb + Double.valueOf(dbcs.get(i).getPb());
//                }
//            }
//            for (int i = 0; i < routerairnwh.size(); i++) {
//                if (routerairnwh.get(i).getLx().equals("无烟煤")) {
//                    bghwympb = bghwympb + Double.valueOf(routerairnwh.get(i).getPb());
//                }
//            }
//            Butvalu butvalu = new Butvalu();
//            if (Double.valueOf(bgqhsj.getTscb()) >= 0) {
//                if (bgqwympb > bghwympb) {
//                    butvalu.setPropertyValue("无烟煤");
//                } else {
//                    butvalu.setPropertyValue("烟煤");
//                }
//            } else {
//                if (bgqwympb > bghwympb) {
//                    butvalu.setPropertyValue("烟煤");
//                } else {
//                    butvalu.setPropertyValue("无烟煤");
//                }
//            }
//            butvaluMapper.update(butvalu, butvaluQueryWrapper1);
//        }
//        return stringListHashMap;
//    }
//
//    public HashMap<String, String> jsqtpjzwym(String gysmc, String bbh, Map<String, String> shm) {
//        HashMap<String, String> stringDoubleHashMap = new HashMap<>();
////      爬虫表采购量,Ad,Vdaf,Fcad,Std,M25,CRI,CSR,Mt
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        calendar.set(Calendar.YEAR, Integer.parseInt(bbh.substring(0, 4)));
//        calendar.set(Calendar.MONTH, Integer.parseInt(bbh.substring(5, 7)) - 1);
//        calendar.set(Calendar.DATE, Integer.parseInt(bbh.substring(8, 10)));
//        calendar.add(Calendar.DATE, -7);
//        Date dateTime = calendar.getTime();
//        String daytose = sdf.format(dateTime);
//        QueryWrapper<Gcilma> jtgrsQueryWrapper = new QueryWrapper<>();
//        jtgrsQueryWrapper.between("jjrq", daytose, bbh);
//        if (gysmc.indexOf("/") != -1) {
//            jtgrsQueryWrapper.eq("gysmc", gysmc.split("/")[0]);
//            jtgrsQueryWrapper.eq("fhdd", gysmc.split("/")[1]);
//        } else {
//            jtgrsQueryWrapper.eq("gysmc", gysmc);
//        }
//        List<Gcilma> jtgrs = gcilmaMapper.selectList(jtgrsQueryWrapper);
//        DecimalFormat df = new DecimalFormat("0.00");
//        Double tad = 0.00;
//        int sum = 0;
//        ArrayList<Double> Ad = new ArrayList<>();
//        ArrayList<Double> Fcd = new ArrayList<>();
//        ArrayList<Double> Mad = new ArrayList<>();
//        ArrayList<Double> Mt = new ArrayList<>();
//        ArrayList<Double> qgrd = new ArrayList<>();
//        ArrayList<Double> Std = new ArrayList<>();
//        ArrayList<Double> Vdaf = new ArrayList<>();
//        ArrayList<Double> sjzl = new ArrayList<>();
//        ArrayList<Double> k = new ArrayList<>();
//        ArrayList<Double> na = new ArrayList<>();
//        ArrayList<Double> zn = new ArrayList<>();
//        for (int i = 0; i < jtgrs.size(); i++) {
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getAd())) {
//                Ad.add(Double.valueOf(jtgrs.get(i).getAd()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getFcd())) {
//                Fcd.add(Double.valueOf(jtgrs.get(i).getFcd()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getMad())) {
//                Mad.add(Double.valueOf(jtgrs.get(i).getMad()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getMt())) {
//                Mt.add(Double.valueOf(jtgrs.get(i).getMt()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getQgrD())) {
//                qgrd.add(Double.valueOf(jtgrs.get(i).getQgrD()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getStD())) {
//                Std.add(Double.valueOf(jtgrs.get(i).getStD()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getVdaf())) {
//                Vdaf.add(Double.valueOf(jtgrs.get(i).getVdaf()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getSjzl())) {
//                sjzl.add(Double.valueOf(jtgrs.get(i).getSjzl()));
//            }
//            if (!ObjectUtils.isEmpty(shm.get(jtgrs.get(i).getPh()))) {
//                k.add(Double.valueOf(shm.get(jtgrs.get(i).getPh())));
//            }
//        }
//        Double Ad1 = 0.00;
//        Double Fcd1 = 0.00;
//        Double Mad1 = 0.00;
//        Double Mt1 = 0.00;
//        Double qgrd1 = 0.00;
//        Double Std1 = 0.00;
//        Double Vdaf1 = 0.00;
//        Double sjzl1 = 0.00;
//        Double k1 = 0.0;
//        Double na1 = 0.0;
//        Double zn1 = 0.0;
//        for (int i = 0; i < k.size(); i++) {
//            k1 = k1 + k.get(i);
//        }
//        for (int i = 0; i < Ad.size(); i++) {
//            Ad1 = Ad1 + Ad.get(i);
//        }
//        for (int i = 0; i < Fcd.size(); i++) {
//            Fcd1 = Fcd1 + Fcd.get(i);
//        }
//        for (int i = 0; i < Mad.size(); i++) {
//            Mad1 = Mad1 + Mad.get(i);
//        }
//        for (int i = 0; i < Mt.size(); i++) {
//            Mt1 = Mt1 + Mt.get(i);
//        }
//        for (int i = 0; i < qgrd.size(); i++) {
//            qgrd1 = qgrd1 + qgrd.get(i);
//        }
//        for (int i = 0; i < Std.size(); i++) {
//            Std1 = Std1 + Std.get(i);
//        }
//        for (int i = 0; i < Vdaf.size(); i++) {
//            Vdaf1 = Vdaf1 + Vdaf.get(i);
//        }
//        for (int i = 0; i < sjzl.size(); i++) {
//            sjzl1 = sjzl1 + sjzl.get(i);
//        }
//        if (Ad1 != 0.0) {
//            stringDoubleHashMap.put("Ad", df.format(Ad1 / Ad.size()));
//        }
//        if (Fcd1 != 0.0) {
//            stringDoubleHashMap.put("Fcd", df.format(Fcd1 / Fcd.size()));
//        }
//        if (Mad1 != 0.0) {
//            stringDoubleHashMap.put("Mad", df.format(Mad1 / Mad.size()));
//        }
//        if (Mt1 != 0.0) {
//            stringDoubleHashMap.put("Mt", df.format(Mt1 / Mt.size()));
//        }
//        if (qgrd1 != 0.0) {
//            stringDoubleHashMap.put("qgrd", df.format(qgrd1 / qgrd.size()));
//        }
//        if (Std1 != 0.0) {
//            stringDoubleHashMap.put("Std", df.format(Std1 / Std.size()));
//        }
//        if (Vdaf1 != 0.0) {
//            stringDoubleHashMap.put("vdaf", df.format(Vdaf1 / Std.size()));
//        }
//        if (sjzl1 != 0.00) {
//            stringDoubleHashMap.put("sjzl", df.format(sjzl1));
//        }
//        if (k1 != 0.0) {
//            stringDoubleHashMap.put("K2O", df.format(k1 / k.size()));
//        }
//        return stringDoubleHashMap;
//    }
//
//    public Map<String, String> csujzz() {
//        String a[] = {"焦炭有效热量", "煤比", "焦炭价格", "置换系数"};
//        QueryWrapper<Butvalu> butvaluQueryWrapper = new QueryWrapper<>();
//        butvaluQueryWrapper.eq("attribute_name", a[0]).or().eq("attribute_name", a[1]).or().eq("attribute_name", a[2]).or().eq("attribute_name", a[3]);
//        List<Butvalu> butvalus = butvaluMapper.selectList(butvaluQueryWrapper);
//        HashMap<String, String> shm = new HashMap<>();
//        for (int i = 0; i < butvalus.size(); i++) {
//            switch (butvalus.get(i).getAttributeName()) {
//                case "焦炭有效热量":
//                    shm.put("jtyxrl", butvalus.get(i).getPropertyValue());
//                    break;
//                case "煤比":
//                    shm.put("mby", butvalus.get(i).getPropertyValue());
//                    break;
//                case "焦炭价格":
//                    shm.put("jtjg", butvalus.get(i).getPropertyValue());
//                    break;
//                case "置换系数":
//                    shm.put("zhxs", butvalus.get(i).getPropertyValue());
//                    break;
//                default:
//                    break;
//            }
//        }
//        return shm;
//    }
//
//    public List<DbcsCopy1> routerairnwh(String ourbbhar) {
//        //默认用上一个版本的配比 变更后
//        QueryWrapper<DbcsCopy1> dbcsQueryWrapper1 = new QueryWrapper<>();
//        dbcsQueryWrapper1.groupBy("version");
//        dbcsQueryWrapper1.orderByDesc("version");
//        dbcsQueryWrapper1.last("limit 1");
//        DbcsCopy1 dbcs1 = dbcsCopy1Mapper.selectList(dbcsQueryWrapper1).get(0);
//        QueryWrapper<DbcsCopy1> dbcsQueryWrapper2 = new QueryWrapper<>();
//        dbcsQueryWrapper2.eq("version", dbcs1.getVersion());
//        List<DbcsCopy1> dbcs2 = dbcsCopy1Mapper.selectList(dbcsQueryWrapper2);
//        HashMap<String, String> sgm = new HashMap<>();
//        for (int i = 0; i < dbcs2.size(); i++) {
//            sgm.put(dbcs2.get(i).getGysmc(), dbcs2.get(i).getPb());
//        }
//        //查询烟煤和无烟煤都在一起的表数据
//        List<Wymdcwh> wymdcwhs = wymdcwhMapper.selectList(null);
//        DecimalFormat df = new DecimalFormat("0.00");
//        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
//        for (int i = 0; i < wymdcwhs.size(); i++) {
//            //对比测算过上面表的对象
//            DbcsCopy1 dbcs = new DbcsCopy1();
//            dbcs.setLx(wymdcwhs.get(i).getRllx());
//            dbcs.setGysmc(wymdcwhs.get(i).getDistributorName());
//            dbcs.setFkfs(wymdcwhs.get(i).getSterilise());
//            dbcs.setCcjg(wymdcwhs.get(i).getContractPrice());
//            dbcs.setJssf(wymdcwhs.get(i).getJssf());
//            dbcs.setYfjg(wymdcwhs.get(i).getJsfm());
//            dbcs.setDcjg(df.format(Double.valueOf(dbcs.getCcjg()) + Double.valueOf(dbcs.getYfjg())));
//            //不含税价格 出厂价格/1.13/（100-结算水分）/100+运费价格/1.09
//            dbcs.setBhsjg(df.format(Double.valueOf(dbcs.getCcjg()) / 1.13 / ((100 - Double.valueOf(dbcs.getJssf())) / 100) +
//                    (Double.valueOf(dbcs.getYfjg())) / 1.09));
//            if (dbcs.getLx().equals("无烟煤")) {
//                //无烟煤基础数据
//                QueryWrapper<Wymjc> jtwq = new QueryWrapper<>();
//                jtwq.eq("gysmc", dbcs.getGysmc());
//                List<Wymjc> jtbizhbCopy1s = wymjcMapper.selectList(jtwq);
//                Wymjc jtbizhbCopy1 = jtbizhbCopy1s.get(0);
//                dbcs.setAd(df.format(Double.valueOf(jtbizhbCopy1.getAd())));
//                dbcs.setStd(df.format(Double.valueOf(jtbizhbCopy1.getStD())));
//                dbcs.setQgrd(df.format(Double.valueOf(jtbizhbCopy1.getQgrD())));
//                dbcs.setVdaf(df.format(Double.valueOf(jtbizhbCopy1.getVdaf())));
//                dbcs.setFcd(df.format(Double.valueOf(jtbizhbCopy1.getFcd())));
//                dbcs.setMt(df.format(Double.valueOf(jtbizhbCopy1.getMt())));
//                dbcs.setMad(df.format(Double.valueOf(jtbizhbCopy1.getMad())));
//            } else {
//                //无烟煤基础数据
//                QueryWrapper<Ymjc> jtwq = new QueryWrapper<>();
//                jtwq.eq("gysmc", dbcs.getGysmc());
//                List<Ymjc> jtbizhbCopy1s = ymjcMapper.selectList(jtwq);
//                Ymjc jtbizhbCopy1 = jtbizhbCopy1s.get(0);
//                dbcs.setAd(df.format(Double.valueOf(jtbizhbCopy1.getAd())));
//                dbcs.setStd(df.format(Double.valueOf(jtbizhbCopy1.getStD())));
//                dbcs.setQgrd(df.format(Double.valueOf(jtbizhbCopy1.getQgrD())));
//                dbcs.setVdaf(df.format(Double.valueOf(jtbizhbCopy1.getVdaf())));
//                dbcs.setFcd(df.format(Double.valueOf(jtbizhbCopy1.getFcd())));
//                dbcs.setMt(df.format(Double.valueOf(jtbizhbCopy1.getMt())));
//                dbcs.setMad(df.format(Double.valueOf(jtbizhbCopy1.getMad())));
//            }
//            HashMap<String, String> shm = new HashMap<>();
//            HashMap<String, String> jsqtpjz = jsqtpjzwym(dbcs.getGysmc(), ourbbhar, shm);
//            if (jsqtpjz.containsKey("Ad")) {
//                dbcs.setAd(df.format(Double.valueOf(jsqtpjz.get("Ad"))));
//            }
//            if (jsqtpjz.containsKey("Vdaf")) {
//                dbcs.setVdaf(df.format(Double.valueOf(jsqtpjz.get("Vdaf"))));
//            }
//            if (jsqtpjz.containsKey("Fcd")) {
//                dbcs.setFcd(df.format(Double.valueOf(jsqtpjz.get("Fcd"))));
//            }
//            if (jsqtpjz.containsKey("Mad")) {
//                dbcs.setMad(df.format(Double.valueOf(jsqtpjz.get("Mad"))));
//            }
//            if (jsqtpjz.containsKey("Mt")) {
//                dbcs.setMt(df.format(Double.valueOf(jsqtpjz.get("Mt"))));
//            }
//            if (jsqtpjz.containsKey("qgrd")) {
//                dbcs.setQgrd(df.format(Double.valueOf(jsqtpjz.get("qgrd"))));
//            }
//            if (jsqtpjz.containsKey("Std")) {
//                dbcs.setStd(df.format(Double.valueOf(jsqtpjz.get("Std"))));
//            }
//            if (jsqtpjz.containsKey("vdaf")) {
//                dbcs.setVdaf(df.format(Double.valueOf(jsqtpjz.get("vdaf"))));
//            }
//            //无烟煤有效热量 9400*FCd-2800*Ad-20000*St,d
//            if (dbcs.getLx().equals("无烟煤")) {
//                dbcs.setYxrl(df.format(9400 * Double.valueOf(dbcs.getFcd()) - 2800 * Double.valueOf(dbcs.getAd())
//                        - 20000 * Double.valueOf(dbcs.getStd())));
//            } else {
//                dbcs.setYxrl(df.format(8400 * Double.valueOf(dbcs.getFcd()) - 2800 * Double.valueOf(dbcs.getAd())
//                        - 20000 * Double.valueOf(dbcs.getStd())));
//            }
//            //单位有效热量成本 不含税价格/有效热量
//            dbcs.setYxrcb(decimalFormat.format(Double.valueOf(dbcs.getBhsjg()) / Double.valueOf(dbcs.getYxrl())));
//            dbcs.setPb(ObjectUtils.isEmpty(sgm.get(dbcs.getGysmc())) ? "0" : sgm.get(dbcs.getGysmc()));
//            dbcs.setVersion(ourbbhar);
//            dbcsCopy1Mapper.insert(dbcs);
//        }
//        QueryWrapper<DbcsCopy1> dbcsQueryWrapper = new QueryWrapper<>();
//        dbcsQueryWrapper.eq("version", ourbbhar);
//        List<DbcsCopy1> dbcs = dbcsCopy1Mapper.selectList(dbcsQueryWrapper);
//        return dbcs;
//    }
//
//    @Test
//    public void sendPosts() {
//        JSONObject jsonObject = new JSONObject();
//        ArrayList<String> strings = new ArrayList<>();
//        strings.add("63df0072");
//        jsonObject.put("id", strings);
//        jsonObject.put("beginTime", "2022-04-24 00:00:01");
//        jsonObject.put("endTime", "2022-04-24 11:59:59");
//        jsonObject.put("limit", 3600);
//        String s = jsonObject.toJSONString();
//        HttpResponse execute = HttpRequest.post("http://e.ai:8083/data-governance/sensor/batch/sv/seconds/all").body(s).execute();
//        JSONObject jsonObject1 = JSONObject.parseObject(execute.body());
//        JSONArray jsonArray = JSONArray.parseArray(jsonObject1.getString("data"));
//        JSONObject jsonObject2 = jsonArray.getJSONObject(0);
//        JSONArray datas = jsonObject2.getJSONArray("datas");
//        JSONObject jsonObject3 = datas.getJSONObject(0);
//        //System.out.println(jsonObject3.getString("v"));
//        System.out.println(datas);
//    }
//
//    @Test
//    public void gture() {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String format = df.format(new Date());
//        System.out.println(format + " " + "00:00:00");
//    }
//
//    @Test
//    public void gucieailsoui() {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        Date date = new Date();
//        String format = simpleDateFormat.format(date);
//        QueryWrapper<JcwyCopy1> jcwyCopy1QueryWrapper = new QueryWrapper<>();
//        jcwyCopy1QueryWrapper.groupBy("version");
//        List<JcwyCopy1> jcwyCopy1s = jcwyCopy1Mapper.selectList(jcwyCopy1QueryWrapper);
//        JcwyCopy1 jcwyCopy1 = jcwyCopy1s.get(jcwyCopy1s.size() - 1);
//        String version = jcwyCopy1.getVersion();
//        QueryWrapper<JcwyCopy1> jcwyCopy1QueryWrapper1 = new QueryWrapper<>();
//        jcwyCopy1QueryWrapper1.eq("version", version);
//        List<JcwyCopy1> jcwyCopy1s1 = jcwyCopy1Mapper.selectList(jcwyCopy1QueryWrapper1);
//        for (int i = 0; i < jcwyCopy1s1.size(); i++) {
//            JcwyCopy1 jcwyCopy11 = new JcwyCopy1();
//            jcwyCopy11.setMaterialName(jcwyCopy1s1.get(i).getMaterialName());
//            jcwyCopy11.setDistributorName(jcwyCopy1s1.get(i).getDistributorName());
//            jcwyCopy11.setGsdgils(jcwyCopy1s1.get(i).getGsdgils());
//            jcwyCopy11.setSterilise(jcwyCopy1s1.get(i).getSterilise());
//            jcwyCopy11.setContractPrice(jcwyCopy1s1.get(i).getContractPrice());
//            jcwyCopy11.setMonthAmount(jcwyCopy1s1.get(i).getMonthAmount());
//            jcwyCopy11.setJssf(jcwyCopy1s1.get(i).getJssf());
//            jcwyCopy11.setJsfm(jcwyCopy1s1.get(i).getJsfm());
//            jcwyCopy11.setVersion(format);
//            jcwyCopy11.setJzzaniu(jcwyCopy1s1.get(i).getJzzaniu());
//            jcwyCopy11.setZltj(jcwyCopy1s1.get(i).getZltj());
//            jcwyCopy11.setKdl(jcwyCopy1s1.get(i).getKdl());
//            jcwyCopy1Mapper.insert(jcwyCopy11);
//        }
//    }
//
//    @Test
//    public List<JcwyCopy1Copy1> selecttocopycopy(String bbh, String tml, String tal) {
//        QueryWrapper<JcwyCopy1Copy1> jq = new QueryWrapper<>();
//        jq.eq("versionrs", bbh);
//        List<JcwyCopy1Copy1> jcwyCopy1Copy1s = jcwyCopy1Copy1Mapper.selectList(jq);
//        if (!ObjectUtils.isEmpty(jcwyCopy1Copy1s)) {
//            return jcwyCopy1Copy1s;
//        }
//        //先查询非常规表中的所有数据存入map集合
//        QueryWrapper<Unconventionality> unconventionalityQueryWrapper = new QueryWrapper<>();
//        unconventionalityQueryWrapper.eq("item", "K2O");
//        unconventionalityQueryWrapper.between("date", tml, tal);
//        unconventionalityQueryWrapper.eq("date", bbh.substring(0, 10));
//        unconventionalityQueryWrapper.like("number", "fs");
//        List<Unconventionality> uci = unconventionalityMapper.selectList(unconventionalityQueryWrapper);
//        HashMap<String, String> shm = new HashMap<>();
//        for (int i = 0; i < uci.size(); i++) {
//            shm.put(uci.get(i).getNumber(), uci.get(i).getPrice());
//        }
//        /*新增步骤先去copy1表查询基准值为1的信息,然后查询该条信息的各个元素的7天平均数,之后根据这个平局数做差计算顶层的数据*/
//        JcwyCopy1Copy1 selectjzxxsjgls = selectjzxxsjgls(bbh, shm);
//        QueryWrapper<JcwyCopy1> jw = new QueryWrapper<>();
//        if (ObjectUtils.isEmpty(tml) && ObjectUtils.isEmpty(tal)) {
//            jw.eq("version", bbh);
//        } else {
//            // HH:mm:ss
//            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            try {
//                jw.between("version", sd.parse(tml), sd.parse(tal));
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        List<JcwyCopy1> jcwyCopy1s = jcwyCopy1Mapper.selectList(jw);
//        ArrayList<JcwyCopy1Copy1> jcwyCopy1Copy1s1 = new ArrayList<>();
//        for (int i = 0; i < jcwyCopy1s.size(); i++) {
//            JcwyCopy1Copy1 jcwyCopy1Copy1 = new JcwyCopy1Copy1();
//            jcwyCopy1Copy1.setMaterialName(jcwyCopy1s.get(i).getMaterialName());
//            jcwyCopy1Copy1.setDistributorName(jcwyCopy1s.get(i).getDistributorName());
//            jcwyCopy1Copy1.setSterilise(jcwyCopy1s.get(i).getSterilise());
//            jcwyCopy1Copy1.setContractPrice(jcwyCopy1s.get(i).getContractPrice());
//            jcwyCopy1Copy1.setMonthAmount(jcwyCopy1s.get(i).getMonthAmount());
//            jcwyCopy1Copy1.setJssf(jcwyCopy1s.get(i).getJssf());
//            jcwyCopy1Copy1.setJsfm(jcwyCopy1s.get(i).getJsfm());
//            jcwyCopy1Copy1.setVersion(jcwyCopy1s.get(i).getVersion());
//            jcwyCopy1Copy1.setGsdgils(jcwyCopy1s.get(i).getGsdgils());
//            jcwyCopy1Copy1.setZltj(jcwyCopy1s.get(i).getZltj());
//            jcwyCopy1Copy1.setKdl(jcwyCopy1s.get(i).getKdl());
//            QueryWrapper<JtbizhbCopy1> jtwq = new QueryWrapper<>();
//            jtwq.eq("gysmc", jcwyCopy1s.get(i).getDistributorName());
//            List<JtbizhbCopy1> jtbizhbCopy1s = jtbizhbCopy1Mapper.selectList(jtwq);
//            DecimalFormat df = new DecimalFormat("0.00");
//            if (ObjectUtils.isEmpty(jcwyCopy1s.get(i).getKdl())) {
//                continue;
//            }
//            Double v = Double.valueOf(jcwyCopy1s.get(i).getKdl()) / 100;
//            Double aDouble = v * Double.valueOf(jcwyCopy1s.get(i).getContractPrice());
//            Double ContractP = Double.valueOf(jcwyCopy1s.get(i).getContractPrice());
//            Double Zltj = Double.valueOf(jcwyCopy1s.get(i).getZltj());
//            jcwyCopy1Copy1.setSjjg(df.format(Zltj + ContractP + aDouble));
//            JtbizhbCopy1 jtbizhbCopy1 = jtbizhbCopy1s.get(0);
//            jcwyCopy1Copy1.setAd(df.format(Double.valueOf(jtbizhbCopy1.getAd())));
//            jcwyCopy1Copy1.setVdaf(df.format(Double.valueOf(jtbizhbCopy1.getVdaf())));
//            jcwyCopy1Copy1.setFcad(df.format(Double.valueOf(jtbizhbCopy1.getFcad())));
//            jcwyCopy1Copy1.setStd(df.format(Double.valueOf(jtbizhbCopy1.getStd())));
//            jcwyCopy1Copy1.setM25(df.format(Double.valueOf(jtbizhbCopy1.getM25())));
//            jcwyCopy1Copy1.setCri(df.format(Double.valueOf(jtbizhbCopy1.getCri())));
//            jcwyCopy1Copy1.setCsr(df.format(Double.valueOf(jtbizhbCopy1.getCsr())));
//            jcwyCopy1Copy1.setMt(df.format(Double.valueOf(jtbizhbCopy1.getMt())));
//            jcwyCopy1Copy1.setK(df.format(Double.valueOf(jtbizhbCopy1.getK())));
//            jcwyCopy1Copy1.setNa(df.format(Double.valueOf(jtbizhbCopy1.getNa())));
//            jcwyCopy1Copy1.setZn(df.format(Double.valueOf(jtbizhbCopy1.getZn())));
////          爬虫表采购量,Ad,Vdaf,Fcad,Std,M25,CRI,CSR,Mt
//            HashMap<String, String> jsqtpjz = jsqtpjz(jcwyCopy1s.get(i).getDistributorName(), bbh, shm);
//            if (jsqtpjz.containsKey("Ad")) {
//                jcwyCopy1Copy1.setAd(df.format(Double.valueOf(jsqtpjz.get("Ad"))));
//            }
//            if (jsqtpjz.containsKey("Vdaf")) {
//                jcwyCopy1Copy1.setVdaf(df.format(Double.valueOf(jsqtpjz.get("Vdaf"))));
//            }
//            if (jsqtpjz.containsKey("Fcad")) {
//                jcwyCopy1Copy1.setFcad(df.format(Double.valueOf(jsqtpjz.get("Fcad"))));
//            }
//            if (jsqtpjz.containsKey("Std")) {
//                jcwyCopy1Copy1.setStd(df.format(Double.valueOf(jsqtpjz.get("Std"))));
//            }
//            if (jsqtpjz.containsKey("M25")) {
//                jcwyCopy1Copy1.setM25(df.format(Double.valueOf(jsqtpjz.get("M25"))));
//            }
//            if (jsqtpjz.containsKey("CRI")) {
//                jcwyCopy1Copy1.setCri(df.format(Double.valueOf(jsqtpjz.get("CRI"))));
//            }
//            if (jsqtpjz.containsKey("CSR")) {
//                jcwyCopy1Copy1.setCsr(df.format(Double.valueOf(jsqtpjz.get("CSR"))));
//            }
//            if (jsqtpjz.containsKey("Mt")) {
//                jcwyCopy1Copy1.setMt(df.format(Double.valueOf(jsqtpjz.get("Mt"))));
//            }
//            if (jsqtpjz.containsKey("sjzl")) {
//                jcwyCopy1Copy1.setCgl(jsqtpjz.get("sjzl"));
//            }
////           非常规
//            if (jsqtpjz.containsKey("K2O")) {
//                jcwyCopy1Copy1.setK(df.format(Double.valueOf(jsqtpjz.get("K2O"))));
//            }
//            if (jsqtpjz.containsKey("Na2O")) {
//                jcwyCopy1Copy1.setNa(df.format(Double.valueOf(jsqtpjz.get("Na2O"))));
//            }
//            if (jsqtpjz.containsKey("ZnO")) {
//                jcwyCopy1Copy1.setZn(df.format(Double.valueOf(jsqtpjz.get("ZnO"))));
//            }
//            //基准值查询
//            QueryWrapper<Butvalu> butvaluQueryWrapper = new QueryWrapper<>();
//            butvaluQueryWrapper.eq("attribute_name", "基准值修改");
//            List<Butvalu> butvalus = butvaluMapper.selectList(butvaluQueryWrapper);
//            String propertyValue = butvalus.get(0).getPropertyValue();
//            //合同价格(折成承兑) 现汇=合同价        承兑=现汇*1.025
//            jcwyCopy1Copy1.setJshtjg(df.format(Double.valueOf(jcwyCopy1s.get(i).getContractPrice()) * 1.025));
//            //不含税价格 合同价格/1.13*95/(100-结算水分)              - Double.valueOf(selectfcgtys.get("ZnO"))
//            jcwyCopy1Copy1.setBhsjg(df.format(Double.valueOf(jcwyCopy1Copy1.getSjjg()) / 1.13 * 95 / (100 - Double.valueOf(jcwyCopy1s.get(i).getJssf()))));
//            //干焦比 基准值+Ad*2/100*基准值+Vdaf*5+Std*10*2/100*基准值-M25*0.75/100*基准值-CSR*0.75/100*基准值+CRI*0.53/100*基准值+K/0.05*0.5/100*基准值
//            String k20 = "";
//            Double format = Double.valueOf(propertyValue) + (Double.valueOf(jcwyCopy1Copy1.getAd()) - Double.valueOf(selectjzxxsjgls.getAd())) * 2 / 100 * Double.valueOf(propertyValue) + (Double.valueOf(jcwyCopy1Copy1.getVdaf()) - Double.valueOf(selectjzxxsjgls.getVdaf())) * 5 +
//                    (Double.valueOf(jcwyCopy1Copy1.getStd()) - Double.valueOf(selectjzxxsjgls.getStd())) * 10 * 2 / 100 * Double.valueOf(propertyValue) - (Double.valueOf(jcwyCopy1Copy1.getM25()) - Double.valueOf(selectjzxxsjgls.getM25())) * 0.75 / 100 * Double.valueOf(propertyValue) -
//                    (Double.valueOf(jcwyCopy1Copy1.getCsr()) - Double.valueOf(selectjzxxsjgls.getCsr())) * 0.75 / 100 * Double.valueOf(propertyValue) + (Double.valueOf(jcwyCopy1Copy1.getCri()) - Double.valueOf(selectjzxxsjgls.getCri())) * 0.53 / 100 * Double.valueOf(propertyValue) +
//                    (Double.valueOf(jcwyCopy1Copy1.getK()) - Double.valueOf(selectjzxxsjgls.getK())) / 0.05 * 0.5 / 100 * Double.valueOf(propertyValue);
//            jcwyCopy1Copy1.setGjb(df.format(format));
//            //基准值
//            DecimalFormat decimalFormat = new DecimalFormat("0.000");
//            if ("1".equals(jcwyCopy1s.get(i).getJzzaniu())) {
//                jcwyCopy1Copy1.setGjb(propertyValue);
//                //净焦比
//                String format1 = df.format(Double.valueOf(propertyValue) / (1 - Double.valueOf(jcwyCopy1s.get(i).getJssf()) / 100));
//                jcwyCopy1Copy1.setJjb(format1);
//                //毛焦比
//                String format2 = df.format(Double.valueOf(format1) / (1 - Double.valueOf(jcwyCopy1s.get(i).getJsfm()) / 100));
//                jcwyCopy1Copy1.setMjb(format2);
//                //毛焦成本
//                String format3 = df.format(Double.valueOf(format2) * Double.valueOf(jcwyCopy1Copy1.getBhsjg()) / 1000);
//                jcwyCopy1Copy1.setMjcb(format3);
//                //兑现率 月实际累计到货量/月计划量
//                Calendar cal = Calendar.getInstance();
//                //设置年份
//                cal.set(Calendar.YEAR, Integer.parseInt(bbh.substring(0, 4)));
//                //设置月份
//                cal.set(Calendar.MONTH, Integer.parseInt(bbh.substring(5, 7)) - 1);
//                //获取某月最小天数
//                int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
//                //设置日历中月份的最小天数
//                cal.set(Calendar.DAY_OF_MONTH, firstDay);
//                //格式化日期
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                String firstDayOfMonth = sdf.format(cal.getTime());
//                QueryWrapper<Jtgrs> jtgrsQueryWrapper = new QueryWrapper<>();
//                jtgrsQueryWrapper.between("jjrq", firstDayOfMonth, bbh);
//                List<Jtgrs> jtgrs = jtgrsMapper.selectList(jtgrsQueryWrapper);
//                Double sum = 0.0;
//                for (int i1 = 0; i1 < jtgrs.size(); i1++) {
//                    sum = sum + Double.valueOf(jtgrs.get(i1).getSjzl());
//                }
//                String gmail = "";
//                String sjgils = ObjectUtils.isEmpty(jcwyCopy1Copy1.getCgl()) ? "0" : jcwyCopy1Copy1.getCgl();
//                jcwyCopy1Copy1.setDxl(gmail = decimalFormat.format(Double.valueOf(sjgils) / Double.valueOf(jcwyCopy1s.get(i).getMonthAmount())).equals("∞") || decimalFormat.format(Double.valueOf(sjgils) / Double.valueOf(jcwyCopy1s.get(i).getMonthAmount())).equals("�") ? String.valueOf(0) : df.format(Double.valueOf(sjgils) / Double.valueOf(jcwyCopy1s.get(i).getMonthAmount())));
//                //差异 毛焦成本减基准值的毛焦成本 propertyValue
//                jcwyCopy1Copy1.setCy(df.format(Double.valueOf(jcwyCopy1Copy1.getMjcb()) - Double.valueOf(jcwyCopy1Copy1.getMjcb())));
//                //单焦种的采购量/焦炭总采购量
//                jcwyCopy1Copy1s1.add(jcwyCopy1Copy1);
//                continue;
//            }
//            //净焦比 干焦比/(1-结算水分/100)
//            String format1 = df.format(Double.valueOf(format) / (1 - Double.valueOf(jcwyCopy1s.get(i).getJssf()) / 100));
//            jcwyCopy1Copy1.setJjb(format1);
//            //毛焦比 净焦比/(1-结算粉末/100)
//            String format2 = df.format(Double.valueOf(format1) / (1 - Double.valueOf(jcwyCopy1s.get(i).getJsfm()) / 100));
//            jcwyCopy1Copy1.setMjb(format2);
//            //毛焦成本 毛焦比*不含税价格/1000
//            String format3 = df.format(Double.valueOf(format2) * Double.valueOf(jcwyCopy1Copy1.getBhsjg()) / 1000);
//            jcwyCopy1Copy1.setMjcb(format3);
//            //兑现率 月实际累计到货量/月计划量
//            Calendar cal = Calendar.getInstance();
//            //设置年份
//            cal.set(Calendar.YEAR, Integer.parseInt(bbh.substring(0, 4)));
//            //设置月份
//            cal.set(Calendar.MONTH, Integer.parseInt(bbh.substring(5, 7)) - 1);
//            //获取某月最小天数
//            int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
//            //设置日历中月份的最小天数
//            cal.set(Calendar.DAY_OF_MONTH, firstDay);
//            //格式化日期
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String firstDayOfMonth = sdf.format(cal.getTime());
//            QueryWrapper<Jtgrs> jtgrsQueryWrapper = new QueryWrapper<>();
//            jtgrsQueryWrapper.between("jjrq", firstDayOfMonth, bbh);
//            List<Jtgrs> jtgrs = jtgrsMapper.selectList(jtgrsQueryWrapper);
//            Double sum = 0.0;
//            for (int i1 = 0; i1 < jtgrs.size(); i1++) {
//                sum = sum + Double.valueOf(jtgrs.get(i1).getSjzl());
//            }
//            String gmail = "";
//            String sjgils = ObjectUtils.isEmpty(jcwyCopy1Copy1.getCgl()) ? "0" : jcwyCopy1Copy1.getCgl();
//            jcwyCopy1Copy1.setDxl(gmail = decimalFormat.format(Double.valueOf(sjgils) / Double.valueOf(jcwyCopy1s.get(i).getMonthAmount())).equals("∞") || decimalFormat.format(Double.valueOf(sjgils) / Double.valueOf(jcwyCopy1s.get(i).getMonthAmount())).equals("�") ? String.valueOf(0) : decimalFormat.format(Double.valueOf(sjgils) / Double.valueOf(jcwyCopy1s.get(i).getMonthAmount())));
//            //差异 毛焦成本减基准值的毛焦成本 propertyValue
//            //jcwyCopy1Copy1.setCy(df.format(Double.valueOf(jcwyCopy1Copy1.getMjcb()) - Double.valueOf(propertyValue)));
//            if ("1".equals(jcwyCopy1s.get(i).getJzzaniu())) {
//                jcwyCopy1Copy1.setCy(df.format(Double.valueOf(propertyValue) - Double.valueOf(propertyValue)));
//            }
//            //单焦种的采购量/焦炭总采购量
//            jcwyCopy1Copy1s1.add(jcwyCopy1Copy1);
//        }
//        return jcwyCopy1Copy1s1;
//    }
//
//    /*新增步骤先去copy1表查询基准值为1的信息,然后查询该条信息的各个元素的7天平均数,之后根据这个平局数做差计算顶层的数据*/
//    public JcwyCopy1Copy1 selectjzxxsjgls(String bbh, Map<String, String> shm) {
//        JcwyCopy1Copy1 jcwyCopy1Copy1 = new JcwyCopy1Copy1();
//        QueryWrapper<JcwyCopy1> jqw = new QueryWrapper<>();
//        jqw.eq("jzzaniu", "1");
//        jqw.eq("version", bbh);
//        List<JcwyCopy1> jc1s = jcwyCopy1Mapper.selectList(jqw);
//        JcwyCopy1 jcwyCopy1 = jc1s.get(0);
//        String distributorName = jcwyCopy1.getDistributorName();
//        String version = jcwyCopy1.getVersion();
//        QueryWrapper<JtbizhbCopy1> j1qw = new QueryWrapper<>();
//        j1qw.eq("gysmc", distributorName);
//        List<JtbizhbCopy1> jt1s = jtbizhbCopy1Mapper.selectList(j1qw);
//        JtbizhbCopy1 jtbizhbCopy1 = jt1s.get(0);
//        jcwyCopy1Copy1.setDistributorName(distributorName);
//        jcwyCopy1Copy1.setAd(jtbizhbCopy1.getAd());
//        jcwyCopy1Copy1.setVdaf(jtbizhbCopy1.getVdaf());
//        jcwyCopy1Copy1.setFcad(jtbizhbCopy1.getFcad());
//        jcwyCopy1Copy1.setStd(jtbizhbCopy1.getStd());
//        jcwyCopy1Copy1.setM25(jtbizhbCopy1.getM25());
//        jcwyCopy1Copy1.setCri(jtbizhbCopy1.getCri());
//        jcwyCopy1Copy1.setCsr(jtbizhbCopy1.getCsr());
//        jcwyCopy1Copy1.setMt(jtbizhbCopy1.getMt());
//        jcwyCopy1Copy1.setK(jtbizhbCopy1.getK());
//        jcwyCopy1Copy1.setNa(jtbizhbCopy1.getNa());
//        jcwyCopy1Copy1.setZn(jtbizhbCopy1.getZn());
//        HashMap<String, String> jsqtpjz = jsqtpjz(distributorName, version, shm);
//        if (jsqtpjz.containsKey("Ad")) {
//            jcwyCopy1Copy1.setAd(jsqtpjz.get("Ad"));
//        }
//        if (jsqtpjz.containsKey("Vdaf")) {
//            jcwyCopy1Copy1.setVdaf(jsqtpjz.get("Vdaf"));
//        }
//        if (jsqtpjz.containsKey("Fcad")) {
//            jcwyCopy1Copy1.setFcad(jsqtpjz.get("Fcad"));
//        }
//        if (jsqtpjz.containsKey("Std")) {
//            jcwyCopy1Copy1.setStd(jsqtpjz.get("Std"));
//        }
//        if (jsqtpjz.containsKey("M25")) {
//            jcwyCopy1Copy1.setM25(jsqtpjz.get("M25"));
//        }
//        if (jsqtpjz.containsKey("CRI")) {
//            jcwyCopy1Copy1.setCri(jsqtpjz.get("CRI"));
//        }
//        if (jsqtpjz.containsKey("CSR")) {
//            jcwyCopy1Copy1.setCsr(jsqtpjz.get("CSR"));
//        }
//        if (jsqtpjz.containsKey("Mt")) {
//            jcwyCopy1Copy1.setMt(jsqtpjz.get("Mt"));
//        }
//        if (jsqtpjz.containsKey("K2O")) {
//            jcwyCopy1Copy1.setK(jsqtpjz.get("K2O"));
//        }
//        if (jsqtpjz.containsKey("Na2O")) {
//            jcwyCopy1Copy1.setK(jsqtpjz.get("Na2O"));
//        }
//        if (jsqtpjz.containsKey("ZnO")) {
//            jcwyCopy1Copy1.setK(jsqtpjz.get("ZnO"));
//        }
//        jcwyCopy1Copy1.setDistributorName(distributorName);
//        jcwyCopy1Copy1.setVersion(version);
//        return jcwyCopy1Copy1;
//    }
//
//    public HashMap<String, String> jsqtpjz(String gysmc, String bbh, Map<String, String> shm) {
//        HashMap<String, String> stringDoubleHashMap = new HashMap<>();
////      爬虫表采购量,Ad,Vdaf,Fcad,Std,M25,CRI,CSR,Mt
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        calendar.set(Calendar.YEAR, Integer.parseInt(bbh.substring(0, 4)));
//        calendar.set(Calendar.MONTH, Integer.parseInt(bbh.substring(5, 7)) - 1);
//        calendar.set(Calendar.DATE, Integer.parseInt(bbh.substring(8, 10)));
//        calendar.add(Calendar.DATE, -14);
//        Date dateTime = calendar.getTime();
//        String daytose = sdf.format(dateTime);
//        QueryWrapper<Jtgrs> jtgrsQueryWrapper = new QueryWrapper<>();
//        jtgrsQueryWrapper.between("jjrq", daytose, bbh);
//        if (gysmc.indexOf("/") != -1) {
//            jtgrsQueryWrapper.eq("gysmc", gysmc.split("/")[0]);
//            jtgrsQueryWrapper.eq("fhdd", gysmc.split("/")[1]);
//        } else {
//            jtgrsQueryWrapper.eq("gysmc", gysmc);
//            jtgrsQueryWrapper.eq("fhdd", "");
//        }
//        jtgrsQueryWrapper.ne("ylmc", "喷吹无烟煤");
//        jtgrsQueryWrapper.ne("ylmc", "喷吹烟煤");
//        List<Jtgrs> jtgrs = jtgrsMapper.selectList(jtgrsQueryWrapper);
//        DecimalFormat df = new DecimalFormat("0.00");
//        Double tad = 0.00;
//        int sum = 0;
//        ArrayList<Double> Ad = new ArrayList<>();
//        ArrayList<Double> Vdaf = new ArrayList<>();
//        ArrayList<Double> Fcad = new ArrayList<>();
//        ArrayList<Double> Std = new ArrayList<>();
//        ArrayList<Double> M25 = new ArrayList<>();
//        ArrayList<Double> CRI = new ArrayList<>();
//        ArrayList<Double> CSR = new ArrayList<>();
//        ArrayList<Double> Mt = new ArrayList<>();
//        ArrayList<Double> sjzl = new ArrayList<>();
//        ArrayList<Double> k = new ArrayList<>();
//        ArrayList<Double> na = new ArrayList<>();
//        ArrayList<Double> zn = new ArrayList<>();
//        for (int i = 0; i < jtgrs.size(); i++) {
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getAd())) {
//                Ad.add(Double.valueOf(jtgrs.get(i).getAd()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getVdaf())) {
//                Vdaf.add(Double.valueOf(jtgrs.get(i).getVdaf()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getFcad())) {
//                Fcad.add(Double.valueOf(jtgrs.get(i).getFcad()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getStD())) {
//                Std.add(Double.valueOf(jtgrs.get(i).getStD()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getM25())) {
//                M25.add(Double.valueOf(jtgrs.get(i).getM25()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getCri())) {
//                CRI.add(Double.valueOf(jtgrs.get(i).getCri()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getCsr())) {
//                CSR.add(Double.valueOf(jtgrs.get(i).getCsr()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getMt())) {
//                Mt.add(Double.valueOf(jtgrs.get(i).getMt()));
//            }
//            if (!ObjectUtils.isEmpty(jtgrs.get(i).getSjzl())) {
//                sjzl.add(Double.valueOf(jtgrs.get(i).getSjzl()));
//            }
//            if (!ObjectUtils.isEmpty(shm.get(jtgrs.get(i).getPh()))) {
//                k.add(Double.valueOf(shm.get(jtgrs.get(i).getPh())));
//            }
//        }
//        Double Ad1 = 0.00;
//        Double Vdaf1 = 0.00;
//        Double Fcad1 = 0.00;
//        Double Std1 = 0.00;
//        Double M251 = 0.00;
//        Double CRI1 = 0.00;
//        Double CSR1 = 0.00;
//        Double Mt1 = 0.00;
//        Double sjzl1 = 0.00;
//        Double k1 = 0.0;
//        Double na1 = 0.0;
//        Double zn1 = 0.0;
//        for (int i = 0; i < k.size(); i++) {
//            k1 = k1 + k.get(i);
//        }
//        for (int i = 0; i < Ad.size(); i++) {
//            Ad1 = Ad1 + Ad.get(i);
//        }
//        for (int i = 0; i < Vdaf.size(); i++) {
//            Vdaf1 = Vdaf1 + Vdaf.get(i);
//        }
//        for (int i = 0; i < Fcad.size(); i++) {
//            Fcad1 = Fcad1 + Fcad.get(i);
//        }
//        for (int i = 0; i < Std.size(); i++) {
//            Std1 = Std1 + Std.get(i);
//        }
//        for (int i = 0; i < M25.size(); i++) {
//            M251 = M251 + M25.get(i);
//        }
//        for (int i = 0; i < CRI.size(); i++) {
//            CRI1 = CRI1 + CRI.get(i);
//        }
//        for (int i = 0; i < CSR.size(); i++) {
//            CSR1 = CSR1 + CSR.get(i);
//        }
//        for (int i = 0; i < Mt.size(); i++) {
//            Mt1 = Mt1 + Mt.get(i);
//        }
//        for (int i = 0; i < sjzl.size(); i++) {
//            sjzl1 = sjzl1 + sjzl.get(i);
//        }
//        if (Ad1 != 0.0) {
//            stringDoubleHashMap.put("Ad", df.format(Ad1 / Ad.size()));
//        }
//        if (Vdaf1 != 0.0) {
//            stringDoubleHashMap.put("Vdaf", df.format(Vdaf1 / Vdaf.size()));
//        }
//        if (Fcad1 != 0.0) {
//            stringDoubleHashMap.put("Fcad", df.format(Fcad1 / Fcad.size()));
//        }
//        if (Std1 != 0.0) {
//            stringDoubleHashMap.put("Std", df.format(Std1 / Std.size()));
//        }
//        if (M251 != 0.0) {
//            stringDoubleHashMap.put("M25", df.format(M251 / M25.size()));
//        }
//        if (CRI1 != 0.0) {
//            stringDoubleHashMap.put("CRI", df.format(CRI1 / M25.size()));
//        }
//        if (CSR1 != 0.0) {
//            stringDoubleHashMap.put("CSR", df.format(CSR1 / CSR.size()));
//        }
//        if (Mt1 != 0.0) {
//            stringDoubleHashMap.put("Mt", df.format(Mt1 / Mt.size()));
//        }
//        if (sjzl1 != 0.0) {
//            stringDoubleHashMap.put("sjzl", df.format(sjzl1));
//        }
//        if (k1 != 0.0) {
//            stringDoubleHashMap.put("K2O", df.format(k1 / k.size()));
//        }
//        return stringDoubleHashMap;
//    }
//
//}
