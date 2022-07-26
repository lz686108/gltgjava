package tceia.eqours;


import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tceia.fsIronReport82.entity.Ironnodata;
import tceia.fsIronReport82.mapper.IronnodataMapper;
import tceia.machineRepair8015.entity.Item;
import tceia.machineRepair8015.mapper.ItemMapper;
import tceia.ylxjb.entity.*;
import tceia.ylxjb.mapper.*;

import javax.crypto.MacSpi;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/tceia/eqours")
@Component
public class Vuegl {
    @Autowired
    public VueglGlMapper vueglGlMapper;
    @Autowired
    public ItemMapper itemMapper;
    @Autowired
    public VueglShigongguankongMapper vueglShigongguankongMapper;
    @Autowired
    public VueGysphMapper vueGysphMapper;
    @Autowired
    public TemmieMapper temmieMapper;
    @Autowired
    public GltgMapper gltgMapper;
    @Autowired
    public IronnodataMapper ironnodataMapper;
    @Autowired
    public BiaozhunyjjcMapper biaozhunyjjcMapper;
    @Autowired
    public ZqwhbihMapper zqwhbihMapper;


    //初始化查询材料信息
    @RequestMapping("selectclxx")
    public List<VueglGl> selectclxx(String glig, String tebbhnmu) {
        QueryWrapper<VueglGl> vueqw = new QueryWrapper<>();
        switch (glig) {
            case "0":
                vueqw.eq("lhnubm", "1号高炉");
                break;
            case "1":
                vueqw.eq("lhnubm", "2号高炉");
                break;
            case "2":
                vueqw.eq("lhnubm", "3号高炉");
                break;
            case "3":
                vueqw.eq("lhnubm", "4号高炉");
                break;
            case "4":
                vueqw.eq("lhnubm", "5号高炉");
                break;
        }
        vueqw.eq("bbh", tebbhnmu);
        List<VueglGl> vueglGls = vueglGlMapper.selectList(vueqw);
        return vueglGls;
    }

    @RequestMapping("selectzhouqi")
    public List<Zqwhbih> selectzhouqi() {
        List<Zqwhbih> zqwhbihs = zqwhbihMapper.selectList(null);
        return zqwhbihs;
    }

    //先删除再保存
    @RequestMapping("deleupta")
    public String deleupta(String geors, String tebbhnmu) {
        JSONArray jsonArray = JSONArray.parseArray(geors);
        //炉号
        String lhnubm = jsonArray.getJSONObject(0).getString("lhnubm");
        //重新存储
        JSONObject jsonObject0 = jsonArray.getJSONObject(0);
        JSONObject jsonObject5 = jsonArray.getJSONObject(5);
        //厂家
        String changjia = jsonObject0.getString("changjia");
        //编号
        String bianhao0 = jsonObject0.getString("bianhao");
        String bianhao5 = jsonObject5.getString("bianhao");
        //到货日期
        String dhdate0 = jsonObject0.getString("dhdate");
        String dhdate5 = jsonObject5.getString("dhdate");
        //实际
        String shiji0 = jsonObject0.getString("shiji");
        String shiji5 = jsonObject5.getString("shiji");
        //存放地点
        String cunfangdidian0 = jsonObject0.getString("cunfangdidian");
        String cunfangdidian5 = jsonObject5.getString("cunfangdidian");
        //前端talbe合并问题,循环分为每五个一组
        for (int i = 0; i < 5; i++) {
            VueglGl vueglGl = new VueglGl();
            vueglGl.setLhnubm(lhnubm);
            vueglGl.setBbh(jsonArray.getJSONObject(i).getString("bbh"));
            vueglGl.setChangjia(changjia);
            vueglGl.setBianhao(bianhao0);
            vueglGl.setDhdate(dhdate0);
            vueglGl.setJianyanjieguo(jsonArray.getJSONObject(i).getString("jianyanjieguo"));
            vueglGl.setJieguopanding(jsonArray.getJSONObject(i).getString("jieguopanding"));
            vueglGl.setShiji(shiji0);
            vueglGl.setCunfangdidian(cunfangdidian0);
            QueryWrapper<VueglGl> vueglGlQueryWrapper = new QueryWrapper<>();
            vueglGlQueryWrapper.eq("id", jsonArray.getJSONObject(i).getString("id"));
            vueglGlMapper.update(vueglGl, vueglGlQueryWrapper);
        }
        for (int i = 5; i < 10; i++) {
            VueglGl vueglGl = new VueglGl();
            vueglGl.setLhnubm(lhnubm);
            vueglGl.setBbh(jsonArray.getJSONObject(i).getString("bbh"));
            vueglGl.setChangjia(changjia);
            vueglGl.setBianhao(bianhao5);
            vueglGl.setDhdate(dhdate5);
            vueglGl.setJianyanjieguo(jsonArray.getJSONObject(i).getString("jianyanjieguo"));
            vueglGl.setJieguopanding(jsonArray.getJSONObject(i).getString("jieguopanding"));
            vueglGl.setShiji(shiji5);
            vueglGl.setCunfangdidian(cunfangdidian5);
            QueryWrapper<VueglGl> vueglGlQueryWrapper = new QueryWrapper<>();
            vueglGlQueryWrapper.eq("id", jsonArray.getJSONObject(i).getString("id"));
            vueglGlMapper.update(vueglGl, vueglGlQueryWrapper);
        }
        return "1";
    }

    //修改材料信息
    @RequestMapping("updatedaget")
    public void updatedaget(String geors, String glnumb) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sf.format(date);
        JSONArray jsonArray = JSONArray.parseArray(geors);
        JSONObject jsonObject0 = jsonArray.getJSONObject(0);
        JSONObject jsonObject5 = jsonArray.getJSONObject(5);
        //厂家
        String changjia = jsonObject0.getString("changjia");
        //编号
        String bianhao0 = jsonObject0.getString("bianhao");
        String bianhao5 = jsonObject5.getString("bianhao");
        //到货日期
        String dhdate0 = jsonObject0.getString("dhdate");
        String dhdate5 = jsonObject5.getString("dhdate");
        //实际
        String shiji0 = jsonObject0.getString("shiji");
        String shiji5 = jsonObject5.getString("shiji");
        //存放地点
        String cunfangdidian0 = jsonObject0.getString("cunfangdidian");
        String cunfangdidian5 = jsonObject5.getString("cunfangdidian");
        //前端talbe合并问题,循环分为每五个一组
        for (int i = 0; i < 5; i++) {
            VueglGl vueglGl = new VueglGl();
            vueglGl.setLhnubm(glnumb);
            vueglGl.setBbh(format);
            vueglGl.setChangjia(changjia);
            vueglGl.setBianhao(bianhao0);
            vueglGl.setDhdate(dhdate0);
            vueglGl.setJianyanjieguo(jsonArray.getJSONObject(i).getString("jianyanjieguo"));
            vueglGl.setJieguopanding(jsonArray.getJSONObject(i).getString("jieguopanding"));
            vueglGl.setShiji(shiji0);
            vueglGl.setCunfangdidian(cunfangdidian0);
            vueglGlMapper.insert(vueglGl);
        }
        for (int i = 5; i < 10; i++) {
            VueglGl vueglGl = new VueglGl();
            vueglGl.setLhnubm(glnumb);
            vueglGl.setBbh(format);
            vueglGl.setChangjia(changjia);
            vueglGl.setBianhao(bianhao5);
            vueglGl.setDhdate(dhdate5);
            vueglGl.setJianyanjieguo(jsonArray.getJSONObject(i).getString("jianyanjieguo"));
            vueglGl.setJieguopanding(jsonArray.getJSONObject(i).getString("jieguopanding"));
            vueglGl.setShiji(shiji5);
            vueglGl.setCunfangdidian(cunfangdidian5);
            vueglGlMapper.insert(vueglGl);
        }

    }

    //顶层材料查询大修距今天数
    @RequestMapping("selectglforf")
    public Object selectglforf() throws Exception {
        String a[] = {"1号高炉", "2号高炉", "3号高炉", "4号高炉", "5号高炉"};
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(date);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            QueryWrapper<Item> itemQueryWrapper = new QueryWrapper<>();
            itemQueryWrapper.eq("process", a[i]);
            itemQueryWrapper.orderByDesc("actualStartDate");
            itemQueryWrapper.between("planTime", 18, 30);
            itemQueryWrapper.last("limit 1");
            Item items = itemMapper.selectList(itemQueryWrapper).get(0);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            long time1 = cal.getTimeInMillis();
            cal.setTime(format.parse(items.getActualenddate()));
            long time2 = cal.getTimeInMillis();
            long between_days = (time1 - time2) / (1000 * 3600 * 24);
            strings.add(String.valueOf(between_days));
        }
        return strings;
    }

    //    查询版本号
    @RequestMapping("selectbbh")
    public List<String> selectbbh() {
        QueryWrapper<VueglGl> vueglGlQueryWrapper = new QueryWrapper<>();
        vueglGlQueryWrapper.groupBy("bbh");
        List<VueglGl> vueglGls = vueglGlMapper.selectList(vueglGlQueryWrapper);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < vueglGls.size(); i++) {
            strings.add(vueglGls.get(i).getBbh());
        }
        return strings;
    }

    //新增版本
    @RequestMapping("insernewbbh")
    public void insernewbbh(String bbhe) {
        QueryWrapper<VueglGl> vg = new QueryWrapper<>();
        vg.eq("bbh", bbhe);
        List<VueglGl> vueglGls = vueglGlMapper.selectList(vg);
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sf.format(date);
        for (int i = 0; i < vueglGls.size(); i++) {
            VueglGl vueglGl = new VueglGl();
            vueglGl.setBbh(format);
            vueglGl.setLhnubm(vueglGls.get(i).getLhnubm());
            vueglGl.setChangjia(vueglGls.get(i).getChangjia());
            vueglGl.setBianhao(vueglGls.get(i).getBianhao());
            vueglGl.setDhdate(vueglGls.get(i).getDhdate());
            vueglGl.setJianyanjieguo(vueglGls.get(i).getJianyanjieguo());
            vueglGl.setJieguopanding(vueglGls.get(i).getJieguopanding());
            vueglGl.setShiji(vueglGls.get(i).getShiji());
            vueglGl.setCunfangdidian(vueglGls.get(i).getCunfangdidian());
            vueglGlMapper.insert(vueglGl);
        }
    }

    //初始化查询施工管控版本号
    @RequestMapping("selectsggkbbh")
    public List<String> selectsggkbbh() {
        QueryWrapper<VueglShigongguankong> vueglShigongguankongQueryWrapper = new QueryWrapper<>();
        vueglShigongguankongQueryWrapper.groupBy("lurudate");
        vueglShigongguankongQueryWrapper.last("limit 20");
        List<VueglShigongguankong> vueglShigongguankongs = vueglShigongguankongMapper.selectList(vueglShigongguankongQueryWrapper);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < vueglShigongguankongs.size(); i++) {
            strings.add(vueglShigongguankongs.get(i).getLurudate());
        }
        return strings;
    }

    //根据版本号和炉号查询施工管控数据
    @RequestMapping("selectoutgal")
    public List<VueglShigongguankong> selectoutgal(String bbh, String luhao) {
        QueryWrapper<VueglShigongguankong> vueglShigongguankongQueryWrapper = new QueryWrapper<>();
        vueglShigongguankongQueryWrapper.eq("lurudate", bbh);
        switch (luhao) {
            case "0":
                vueglShigongguankongQueryWrapper.eq("luhao", "1号高炉");
                break;
            case "1":
                vueglShigongguankongQueryWrapper.eq("luhao", "2号高炉");
                break;
            case "2":
                vueglShigongguankongQueryWrapper.eq("luhao", "3号高炉");
                break;
            case "3":
                vueglShigongguankongQueryWrapper.eq("luhao", "4号高炉");
                break;
            case "4":
                vueglShigongguankongQueryWrapper.eq("luhao", "5号高炉");
                break;
            default:
                break;
        }
        List<VueglShigongguankong> vueglShigongguankongs = vueglShigongguankongMapper.selectList(vueglShigongguankongQueryWrapper);
        return vueglShigongguankongs;
    }

    @RequestMapping("deupet")
    public void deupet(String dulist) {
        JSONArray jsonArray = JSONArray.parseArray(dulist);
        for (int i = 0; i < jsonArray.size(); i++) {
            VueglShigongguankong vueglShigongguankong = new VueglShigongguankong();
            vueglShigongguankong.setRdate(jsonArray.getJSONObject(i).getString("rdate"));
            vueglShigongguankong.setBiaozhun(jsonArray.getJSONObject(i).getString("biaozhun"));
            vueglShigongguankong.setYongshi(jsonArray.getJSONObject(i).getString("yongshi"));
            if (!ObjectUtils.isEmpty(jsonArray.getJSONObject(i).getString("cundangzhaopian"))) {
                vueglShigongguankong.setCundangzhaopian(jsonArray.getJSONObject(i).getString("cundangzhaopian"));
            }
            vueglShigongguankong.setGjsscc(jsonArray.getJSONObject(i).getString("gjsscc"));
            vueglShigongguankong.setSsjsrenyuan(jsonArray.getJSONObject(i).getString("ssjsrenyuan"));
            vueglShigongguankong.setGaohugenzong(jsonArray.getJSONObject(i).getString("gaohugenzong"));
            vueglShigongguankong.setShigongyichangjilu(jsonArray.getJSONObject(i).getString("shigongyichangjilu"));
            vueglShigongguankong.setLurudate(jsonArray.getJSONObject(i).getString("lurudate"));
            vueglShigongguankong.setLuhao(jsonArray.getJSONObject(i).getString("luhao"));
            QueryWrapper<VueglShigongguankong> vueglShigongguankongQueryWrapper1 = new QueryWrapper<>();
            vueglShigongguankongQueryWrapper1.eq("id", jsonArray.getJSONObject(i).getString("id"));
            vueglShigongguankongMapper.update(vueglShigongguankong, vueglShigongguankongQueryWrapper1);
        }
    }

    @RequestMapping("insertwebeac")
    public String insertwebeac(String bbh) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sf.format(date);
        if (bbh.equals(format)) {
            return "0";
        }
        QueryWrapper<VueglShigongguankong> vuegs = new QueryWrapper<>();
        vuegs.eq("lurudate", bbh);
        List<VueglShigongguankong> vueglShigongguankongs = vueglShigongguankongMapper.selectList(vuegs);
        for (int i = 0; i < vueglShigongguankongs.size(); i++) {
            VueglShigongguankong vs = new VueglShigongguankong();
            vs.setRdate(vueglShigongguankongs.get(i).getRdate());
            vs.setBiaozhun(vueglShigongguankongs.get(i).getBiaozhun());
            vs.setYongshi(vueglShigongguankongs.get(i).getYongshi());
            vs.setGjsscc(vueglShigongguankongs.get(i).getGjsscc());
            vs.setSsjsrenyuan(vueglShigongguankongs.get(i).getSsjsrenyuan());
            vs.setGaohugenzong(vueglShigongguankongs.get(i).getGaohugenzong());
            vs.setShigongyichangjilu(vueglShigongguankongs.get(i).getShigongyichangjilu());
            vs.setLurudate(format);
            vs.setLuhao(vueglShigongguankongs.get(i).getLuhao());
            vueglShigongguankongMapper.insert(vs);
        }
        return "1";
    }

    //    供应商评价查询版本号
    @RequestMapping("selectgyspjbbh")
    public List<String> selectgyspjbbh() {
        QueryWrapper<VueGysph> vueGysphQueryWrapper = new QueryWrapper<>();
        vueGysphQueryWrapper.groupBy("crdate");
        vueGysphQueryWrapper.last("limit 20");
        List<VueGysph> vueGysphs = vueGysphMapper.selectList(vueGysphQueryWrapper);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < vueGysphs.size(); i++) {
            strings.add(vueGysphs.get(i).getCrdate());
        }
        return strings;
    }

    //根据版本号和炉号查询供应商评价信息
    @RequestMapping("selectgyspjbl")
    public List<VueGysph> selectgyspjbl(String bbhe, String luhoa) {
        QueryWrapper<VueGysph> vueGysphQueryWrapper = new QueryWrapper<>();
        vueGysphQueryWrapper.eq("crdate", bbhe);
        switch (luhoa) {
            case "0":
                vueGysphQueryWrapper.eq("luhao", "1号高炉");
                break;
            case "1":
                vueGysphQueryWrapper.eq("luhao", "2号高炉");
                break;
            case "2":
                vueGysphQueryWrapper.eq("luhao", "3号高炉");
                break;
            case "3":
                vueGysphQueryWrapper.eq("luhao", "4号高炉");
                break;
            case "4":
                vueGysphQueryWrapper.eq("luhao", "5号高炉");
                break;
            default:
                break;
        }
        List<VueGysph> vueGysphs = vueGysphMapper.selectList(vueGysphQueryWrapper);
        return vueGysphs;
    }

    //供应商评价修改信息
    @RequestMapping("updategyspj")
    public void updategyspj(String gyspjlist) {
        JSONArray jsonArray = JSONArray.parseArray(gyspjlist);
        for (int i = 0; i < jsonArray.size(); i++) {
            VueGysph vueGysph = new VueGysph();
            vueGysph.setCsnamers(jsonArray.getJSONObject(i).getString("csnamers"));
            vueGysph.setNcnamers(jsonArray.getJSONObject(i).getString("ncnamers"));
            vueGysph.setDefen1(jsonArray.getJSONObject(i).getString("defen1"));
            vueGysph.setDefen2(jsonArray.getJSONObject(i).getString("defen2"));
            vueGysph.setDefen3(jsonArray.getJSONObject(i).getString("defen3"));
            vueGysph.setDefen4(jsonArray.getJSONObject(i).getString("defen4"));
            vueGysph.setDefen5(jsonArray.getJSONObject(i).getString("defen5"));
            vueGysph.setDefen6(jsonArray.getJSONObject(i).getString("defen6"));
            vueGysph.setDefen7(jsonArray.getJSONObject(i).getString("defen7"));
            vueGysph.setDefen8(jsonArray.getJSONObject(i).getString("defen8"));
            vueGysph.setDefen9(jsonArray.getJSONObject(i).getString("defen9"));
            vueGysph.setDefen10(jsonArray.getJSONObject(i).getString("defen10"));
            vueGysph.setDefen11(jsonArray.getJSONObject(i).getString("defen11"));
            vueGysph.setDefen12(jsonArray.getJSONObject(i).getString("defen12"));
            vueGysph.setDefen13(jsonArray.getJSONObject(i).getString("defen13"));
            vueGysph.setDefen14(jsonArray.getJSONObject(i).getString("defen14"));
            vueGysph.setShuoming1(jsonArray.getJSONObject(i).getString("shuoming1"));
            vueGysph.setShuoming2(jsonArray.getJSONObject(i).getString("shuoming2"));
            vueGysph.setShuoming3(jsonArray.getJSONObject(i).getString("shuoming3"));
            vueGysph.setShuoming4(jsonArray.getJSONObject(i).getString("shuoming4"));
            vueGysph.setShuoming5(jsonArray.getJSONObject(i).getString("shuoming5"));
            vueGysph.setShuoming6(jsonArray.getJSONObject(i).getString("shuoming6"));
            vueGysph.setShuoming7(jsonArray.getJSONObject(i).getString("shuoming7"));
            vueGysph.setShuoming8(jsonArray.getJSONObject(i).getString("shuoming8"));
            vueGysph.setShuoming9(jsonArray.getJSONObject(i).getString("shuoming9"));
            vueGysph.setShuoming10(jsonArray.getJSONObject(i).getString("shuoming10"));
            vueGysph.setShuoming11(jsonArray.getJSONObject(i).getString("shuoming11"));
            vueGysph.setShuoming12(jsonArray.getJSONObject(i).getString("shuoming12"));
            vueGysph.setShuoming13(jsonArray.getJSONObject(i).getString("shuoming13"));
            vueGysph.setShuoming14(jsonArray.getJSONObject(i).getString("shuoming14"));
            QueryWrapper<VueGysph> vueGysphQueryWrapper = new QueryWrapper<>();
            vueGysphQueryWrapper.eq("id", jsonArray.getJSONObject(i).getString("id"));
            vueGysphMapper.update(vueGysph, vueGysphQueryWrapper);
        }
    }

    //供应商评价
    @RequestMapping("insertgyspj")
    public String insertgyspj(String bbhs) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sf.format(date);
        if (format.equals(bbhs)) {
            return "1";
        }
        QueryWrapper<VueGysph> vueGysphQueryWrapper = new QueryWrapper<>();
        vueGysphQueryWrapper.eq("crdate", bbhs);
        List<VueGysph> vueGysphs = vueGysphMapper.selectList(vueGysphQueryWrapper);
        for (int i = 0; i < vueGysphs.size(); i++) {
            VueGysph vueGysph = new VueGysph();
            vueGysph.setCsnamers(vueGysphs.get(i).getCsnamers());
            vueGysph.setNcnamers(vueGysphs.get(i).getNcnamers());
            vueGysph.setDefen1(vueGysphs.get(i).getDefen1());
            vueGysph.setDefen2(vueGysphs.get(i).getDefen2());
            vueGysph.setDefen3(vueGysphs.get(i).getDefen3());
            vueGysph.setDefen4(vueGysphs.get(i).getDefen4());
            vueGysph.setDefen5(vueGysphs.get(i).getDefen5());
            vueGysph.setDefen6(vueGysphs.get(i).getDefen6());
            vueGysph.setDefen7(vueGysphs.get(i).getDefen7());
            vueGysph.setDefen8(vueGysphs.get(i).getDefen8());
            vueGysph.setDefen9(vueGysphs.get(i).getDefen9());
            vueGysph.setDefen10(vueGysphs.get(i).getDefen10());
            vueGysph.setDefen11(vueGysphs.get(i).getDefen11());
            vueGysph.setDefen12(vueGysphs.get(i).getDefen12());
            vueGysph.setDefen13(vueGysphs.get(i).getDefen13());
            vueGysph.setDefen14(vueGysphs.get(i).getDefen14());
            vueGysph.setShuoming1(vueGysphs.get(i).getShuoming1());
            vueGysph.setShuoming2(vueGysphs.get(i).getShuoming2());
            vueGysph.setShuoming3(vueGysphs.get(i).getShuoming3());
            vueGysph.setShuoming4(vueGysphs.get(i).getShuoming4());
            vueGysph.setShuoming5(vueGysphs.get(i).getShuoming5());
            vueGysph.setShuoming6(vueGysphs.get(i).getShuoming6());
            vueGysph.setShuoming7(vueGysphs.get(i).getShuoming7());
            vueGysph.setShuoming8(vueGysphs.get(i).getShuoming8());
            vueGysph.setShuoming9(vueGysphs.get(i).getShuoming9());
            vueGysph.setShuoming10(vueGysphs.get(i).getShuoming10());
            vueGysph.setShuoming11(vueGysphs.get(i).getShuoming11());
            vueGysph.setShuoming12(vueGysphs.get(i).getShuoming12());
            vueGysph.setShuoming13(vueGysphs.get(i).getShuoming13());
            vueGysph.setShuoming14(vueGysphs.get(i).getShuoming14());
            vueGysph.setLuhao(vueGysphs.get(i).getLuhao());
            vueGysph.setCrdate(format);
            vueGysphMapper.insert(vueGysph);
        }
        return "2";
    }

    //运行监测数据储存
    @RequestMapping("insertimeer")
    public void insetteemer(String grklist, String gysmc, String luhaosop, String ztx, String bbh) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sf.format(date);
        String cet = "";
        if (ztx.equals("0")) {
            cet = "渣线";
        } else {
            cet = "铁线";
        }
        JSONObject jsonObject = JSONObject.parseObject(grklist);
        Temmie temmie = new Temmie();
        temmie.setA0(jsonObject.getString("a"));
        temmie.setB1(jsonObject.getString("c"));
        temmie.setC2(jsonObject.getString("e"));
        temmie.setD3(jsonObject.getString("g"));
        temmie.setE4(jsonObject.getString("i"));
        temmie.setF5(jsonObject.getString("k"));
        temmie.setG6(jsonObject.getString("m"));
        temmie.setH7(jsonObject.getString("o"));
        temmie.setI8(jsonObject.getString("q"));
        temmie.setJ9(jsonObject.getString("s"));
        temmie.setK10(jsonObject.getString("u"));
        temmie.setL11(jsonObject.getString("w"));
        temmie.setM12(jsonObject.getString("b"));
        temmie.setN13(jsonObject.getString("d"));
        temmie.setO14(jsonObject.getString("f"));
        temmie.setP15(jsonObject.getString("h"));
        temmie.setQ16(jsonObject.getString("j"));
        temmie.setR17(jsonObject.getString("l"));
        temmie.setS18(jsonObject.getString("n"));
        temmie.setT19(jsonObject.getString("p"));
        temmie.setU20(jsonObject.getString("r"));
        temmie.setV21(jsonObject.getString("t"));
        temmie.setW22(jsonObject.getString("v"));
        temmie.setX23(jsonObject.getString("x"));
        temmie.setWeizhi(gysmc);
        temmie.setLuhao(luhaosop);
        if (!format.equals(bbh)) {
            temmie.setRiqidate(bbh);
        } else {
            temmie.setRiqidate(format);
        }
        temmie.setZtx(cet);
        temmieMapper.insert(temmie);
    }

    @RequestMapping("selectbbheyxjc")
    public List<String> selectbbheyxjc() {
        QueryWrapper<Temmie> temmieQueryWrapper = new QueryWrapper<>();
        temmieQueryWrapper.groupBy("riqidate");
        temmieQueryWrapper.last("limit 20");
        List<Temmie> temmies = temmieMapper.selectList(temmieQueryWrapper);
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < temmies.size(); i++) {
            strings.add(temmies.get(i).getRiqidate());
        }
        return strings;
    }

    //    运行监测
    @RequestMapping("selectechartesl")
    public List<String> selectechartesl(String luhao, String bbh, String weizhi, String tezhax) {
        QueryWrapper<Temmie> temmieQueryWrapper = new QueryWrapper<>();
        temmieQueryWrapper.eq("luhao", luhao);
        temmieQueryWrapper.eq("weizhi", weizhi);
        temmieQueryWrapper.eq("riqidate", bbh);
        temmieQueryWrapper.eq("ztx", tezhax);
        List<Temmie> temmies = temmieMapper.selectList(temmieQueryWrapper);
        ArrayList<String> strings = new ArrayList<>();
        if (ObjectUtils.isEmpty(temmies)) {
            return strings;
        }
        Temmie temmie = temmies.get(temmies.size() - 1);
        strings.add(temmie.getA0());
        strings.add(temmie.getB1());
        strings.add(temmie.getC2());
        strings.add(temmie.getD3());
        strings.add(temmie.getE4());
        strings.add(temmie.getF5());
        strings.add(temmie.getG6());
        strings.add(temmie.getH7());
        strings.add(temmie.getI8());
        strings.add(temmie.getJ9());
        strings.add(temmie.getK10());
        strings.add(temmie.getL11());
        strings.add(temmie.getM12());
        strings.add(temmie.getN13());
        strings.add(temmie.getO14());
        strings.add(temmie.getP15());
        strings.add(temmie.getQ16());
        strings.add(temmie.getR17());
        strings.add(temmie.getS18());
        strings.add(temmie.getT19());
        strings.add(temmie.getU20());
        strings.add(temmie.getV21());
        strings.add(temmie.getW22());
        strings.add(temmie.getX23());
        return strings;
    }

    //   顶层数据维护
    @RequestMapping("zqweih")
    public List<Zqwhbih> zqweih(String zqwih) throws Exception {
        int delete = zqwhbihMapper.delete(null);
        JSONObject jsonObject = JSONObject.parseObject(zqwih);
        Zqwhbih gltg = new Zqwhbih();
        if (!ObjectUtils.isEmpty(jsonObject.getString("a"))) {
            gltg.setA(jsonObject.getString("a"));
        }
        if (!ObjectUtils.isEmpty(jsonObject.getString("b"))) {
            gltg.setB(jsonObject.getString("b"));
        }
        if (!ObjectUtils.isEmpty(jsonObject.getString("c"))) {
            gltg.setC(jsonObject.getString("c"));
        }
        if (!ObjectUtils.isEmpty(jsonObject.getString("d"))) {
            gltg.setD(jsonObject.getString("d"));
        }
        if (!ObjectUtils.isEmpty(jsonObject.getString("e"))) {
            gltg.setE(jsonObject.getString("e"));
        }
        if (!ObjectUtils.isEmpty(jsonObject.getString("f"))) {
            gltg.setF(jsonObject.getString("f"));
        }
        if (!ObjectUtils.isEmpty(jsonObject.getString("g"))) {
            gltg.setG(jsonObject.getString("g"));
        }
        if (!ObjectUtils.isEmpty(jsonObject.getString("h"))) {
            gltg.setH(jsonObject.getString("h"));
        }
        if (!ObjectUtils.isEmpty(jsonObject.getString("i"))) {
            gltg.setI(jsonObject.getString("i"));
        }
        if (!ObjectUtils.isEmpty(jsonObject.getString("j"))) {
            gltg.setJ(jsonObject.getString("j"));
        }
        if (!ObjectUtils.isEmpty(jsonObject.getString("k"))) {
            gltg.setL(jsonObject.getString("k"));
        }
        if (!ObjectUtils.isEmpty(jsonObject.getString("l"))) {
            gltg.setM(jsonObject.getString("l"));
        }
        int insert = zqwhbihMapper.insert(gltg);
        List<Zqwhbih> zqwhbihs = zqwhbihMapper.selectList(null);
        return zqwhbihs;
    }

    //   顶层数据维护
    @RequestMapping("insetdccuipes")
    public List<String> insertdcsjwh(String getea) throws Exception {
        //先查询之前版本信息 做差用
        List<Gltg> gltgs1 = gltgMapper.selectList(null);
        Gltg gltg2 = gltgs1.get(gltgs1.size() - 1);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(date);
        JSONObject jsonObject = JSONObject.parseObject(getea);
        Gltg gltg = new Gltg();
        if (ObjectUtils.isEmpty(jsonObject.getString("a"))) {
            gltg.setAddx(gltg2.getAddx());
        } else {
            gltg.setAddx(jsonObject.getString("a"));
        }
        if (ObjectUtils.isEmpty(jsonObject.getString("b"))) {
            gltg.setAdxx(gltg2.getAdxx());
        } else {
            gltg.setAdxx(jsonObject.getString("b"));
        }
        if (ObjectUtils.isEmpty(jsonObject.getString("c"))) {
            gltg.setAxdx(gltg2.getAxdx());
        } else {
            gltg.setAxdx(jsonObject.getString("c"));
        }
        if (ObjectUtils.isEmpty(jsonObject.getString("d"))) {
            gltg.setAxxx(gltg2.getAxxx());
        } else {
            gltg.setAxxx(jsonObject.getString("d"));
        }
        if (ObjectUtils.isEmpty(jsonObject.getString("e"))) {
            gltg.setBdx(gltg2.getBdx());
        } else {
            gltg.setBdx(jsonObject.getString("e"));
        }
        if (ObjectUtils.isEmpty(jsonObject.getString("f"))) {
            gltg.setBxx(gltg2.getBxx());
        } else {
            gltg.setBxx(jsonObject.getString("f"));
        }
        if (ObjectUtils.isEmpty(jsonObject.getString("g"))) {
            gltg.setCdx(gltg2.getCdx());
        } else {
            gltg.setCdx(jsonObject.getString("g"));
        }
        if (ObjectUtils.isEmpty(jsonObject.getString("h"))) {
            gltg.setCxx(gltg2.getCxx());
        } else {
            gltg.setCxx(jsonObject.getString("h"));
        }
        if (ObjectUtils.isEmpty(jsonObject.getString("i"))) {
            gltg.setDdx(gltg2.getDdx());
        } else {
            gltg.setDdx(jsonObject.getString("i"));
        }
        if (ObjectUtils.isEmpty(jsonObject.getString("j"))) {
            gltg.setDxx(gltg2.getDxx());
        } else {
            gltg.setDxx(jsonObject.getString("j"));
        }
        if (ObjectUtils.isEmpty(jsonObject.getString("k"))) {
            gltg.setEdx(gltg2.getEdx());
        } else {
            gltg.setEdx(jsonObject.getString("k"));
        }
        if (ObjectUtils.isEmpty(jsonObject.getString("l"))) {
            gltg.setExx(gltg2.getExx());
        } else {
            gltg.setExx(jsonObject.getString("l"));
        }
        gltg.setGangodate(format1);
        gltgMapper.insert(gltg);
        List<Gltg> gltgs = gltgMapper.selectList(null);
        Gltg gltg1 = gltgs.get(gltgs.size() - 1);
//        计算日期差
        ArrayList<String> strings = new ArrayList<>();
        strings.add(gltg1.getAddx());
        strings.add(gltg1.getAdxx());
        strings.add(gltg1.getAxdx());
        strings.add(gltg1.getAxxx());
        strings.add(gltg1.getBdx());
        strings.add(gltg1.getBxx());
        strings.add(gltg1.getCdx());
        strings.add(gltg1.getCxx());
        strings.add(gltg1.getDdx());
        strings.add(gltg1.getDxx());
        strings.add(gltg1.getEdx());
        strings.add(gltg1.getExx());
        ArrayList<String> tepe = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            long time1 = cal.getTimeInMillis();
            cal.setTime(format.parse(strings.get(i)));
            long time2 = cal.getTimeInMillis();
            long between_days = (time1 - time2) / (1000 * 3600 * 24);
            tepe.add(String.valueOf(between_days));
        }
        return tepe;
    }


    //顶层日期差
    @RequestMapping("selectconte")
    public List<String> selectconte() throws Exception {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String format1 = format.format(date);
        List<Gltg> gltgs = gltgMapper.selectList(null);
        Gltg gltg1 = gltgs.get(gltgs.size() - 1);
//        计算日期差
        ArrayList<String> strings = new ArrayList<>();
        strings.add(gltg1.getAddx());
        strings.add(gltg1.getAdxx());
        strings.add(gltg1.getAxdx());
        strings.add(gltg1.getAxxx());
        strings.add(gltg1.getBdx());
        strings.add(gltg1.getBxx());
        strings.add(gltg1.getCdx());
        strings.add(gltg1.getCxx());
        strings.add(gltg1.getDdx());
        strings.add(gltg1.getDxx());
        strings.add(gltg1.getEdx());
        strings.add(gltg1.getExx());
        ArrayList<String> tepe = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            long time1 = cal.getTimeInMillis();
            cal.setTime(format.parse(strings.get(i)));
            long time2 = cal.getTimeInMillis();
            long between_days = (time1 - time2) / (1000 * 3600 * 24);
            tepe.add(String.valueOf(between_days));
        }
        return tepe;
    }

    //计算历史平均大修小修
    @RequestMapping("remasteqs")
    public List<String> remasteqs() throws Exception {
        List<Gltg> gltgs = gltgMapper.selectList(null);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        DecimalFormat decimalFormat = new DecimalFormat("0");
        Double addx = 0.0;
        int a = 0;
        Double adxx = 0.0;
        int b = 0;
        Double axdx = 0.0;
        int c = 0;
        Double axxx = 0.0;
        int d = 0;
        Double bdx = 0.0;
        int e = 0;
        Double bxx = 0.0;
        int f = 0;
        Double cdx = 0.0;
        int g = 0;
        Double cxx = 0.0;
        int h = 0;
        Double ddx = 0.0;
        int i1 = 0;
        Double dxx = 0.0;
        int j = 0;
        Double edx = 0.0;
        int k = 0;
        Double exx = 0.0;
        int l = 0;
        for (int i = gltgs.size() - 1; i > 0; i--) {
            if (!gltgs.get(i).getAdxx().equals(gltgs.get(i - 1).getAdxx())) {
                String tegap = tegap(gltgs.get(i).getAddx(), gltgs.get(i - 1).getAddx());
                addx = addx + Double.valueOf(tegap);
                a++;
            }
            if (!gltgs.get(i).getAdxx().equals(gltgs.get(i - 1).getAdxx())) {
                String tegap1 = tegap(gltgs.get(i).getAdxx(), gltgs.get(i - 1).getAdxx());
                adxx = adxx + Double.valueOf(tegap1);
                b++;
            }
            if (!gltgs.get(i).getAxdx().equals(gltgs.get(i - 1).getAxdx())) {
                String tegap2 = tegap(gltgs.get(i).getAxdx(), gltgs.get(i - 1).getAxdx());
                axdx = axdx + Double.valueOf(tegap2);
                c++;
            }
            if (!gltgs.get(i).getAxxx().equals(gltgs.get(i - 1).getAxxx())) {
                String tegap3 = tegap(gltgs.get(i).getAxxx(), gltgs.get(i - 1).getAxxx());
                axxx = axxx + Double.valueOf(tegap3);
                d++;
            }
            if (!gltgs.get(i).getBdx().equals(gltgs.get(i - 1).getBdx())) {
                String tegap4 = tegap(gltgs.get(i).getBdx(), gltgs.get(i - 1).getBdx());
                bdx = bdx + Double.valueOf(tegap4);
                e++;
            }

            if (!gltgs.get(i).getBxx().equals(gltgs.get(i - 1).getBxx())) {
                String tegap5 = tegap(gltgs.get(i).getBxx(), gltgs.get(i - 1).getBxx());
                bxx = bxx + Double.valueOf(tegap5);
                f++;
            }
            if (!gltgs.get(i).getCdx().equals(gltgs.get(i - 1).getCdx())) {
                String tegap6 = tegap(gltgs.get(i).getCdx(), gltgs.get(i - 1).getCdx());
                cdx = cdx + Double.valueOf(tegap6);
                g++;
            }
            if (!gltgs.get(i).getCxx().equals(gltgs.get(i - 1).getCxx())) {
                String tegap7 = tegap(gltgs.get(i).getCxx(), gltgs.get(i - 1).getCxx());
                cxx = cxx + Double.valueOf(tegap7);
                h++;
            }
            if (!gltgs.get(i).getDdx().equals(gltgs.get(i - 1).getDdx())) {
                String tegap8 = tegap(gltgs.get(i).getDdx(), gltgs.get(i - 1).getDdx());
                ddx = ddx + Double.valueOf(tegap8);
                i1++;
            }
            if (!gltgs.get(i).getDxx().equals(gltgs.get(i - 1).getDxx())) {
                String tegap9 = tegap(gltgs.get(i).getDxx(), gltgs.get(i - 1).getDxx());
                dxx = dxx + Double.valueOf(tegap9);
                j++;
            }
            if (!gltgs.get(i).getEdx().equals(gltgs.get(i - 1).getEdx())) {
                String tegap10 = tegap(gltgs.get(i).getEdx(), gltgs.get(i - 1).getEdx());
                edx = edx + Double.valueOf(tegap10);
                k++;
            }
            if (!gltgs.get(i).getExx().equals(gltgs.get(i - 1).getExx())) {
                String tegap11 = tegap(gltgs.get(i).getExx(), gltgs.get(i - 1).getExx());
                exx = exx + Double.valueOf(tegap11);
                l++;
            }
        }
        ArrayList<String> strings = new ArrayList<>();
        strings.add(decimalFormat.format(addx / (a)));
        strings.add(decimalFormat.format(adxx / (b)));
        strings.add(decimalFormat.format(axdx / (c)));
        strings.add(decimalFormat.format(axxx / (d)));
        strings.add(decimalFormat.format(bdx / (e)));
        strings.add(decimalFormat.format(bxx / (f)));
        strings.add(decimalFormat.format(cdx / (g)));
        strings.add(decimalFormat.format(cxx / (h)));
        strings.add(decimalFormat.format(ddx / (i1)));
        strings.add(decimalFormat.format(dxx / (j)));
        strings.add(decimalFormat.format(edx / (k)));
        strings.add(decimalFormat.format(exx / (l)));
        return strings;
    }

    private String tegap(String acea, String acebec) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(format.parse(acea));
        long time1 = cal.getTimeInMillis();
        cal.setTime(format.parse(acebec));
        long time2 = cal.getTimeInMillis();
        long between_days = (time1 - time2) / (1000 * 3600 * 24);
        return String.valueOf(between_days);
    }

    //顶层厂家查询
    @RequestMapping("selectdcchangjia")
    public Map<String, String> selectdcchangjia() {
        List<VueGysph> vueGysphs = vueGysphMapper.selectList(null);
        String crdate = vueGysphs.get(vueGysphs.size() - 1).getCrdate();
        QueryWrapper<VueGysph> vgqw = new QueryWrapper<>();
        vgqw.eq("crdate", crdate);
        List<VueGysph> vueGysphs1 = vueGysphMapper.selectList(vgqw);
        DecimalFormat df = new DecimalFormat("0");
        HashMap<String, String> sh = new HashMap<>();
        for (int i = 0; i < vueGysphs1.size(); i++) {
            switch (vueGysphs1.get(i).getLuhao()) {
                case "1号高炉":
                    sh.put("gaolu1", vueGysphs1.get(i).getCsnamers());
                    sh.put("df1", df.format(Double.valueOf(vueGysphs1.get(i).getDefen1()) + Double.valueOf(vueGysphs1.get(i).getDefen2()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen3()) + Double.valueOf(vueGysphs1.get(i).getDefen4()) + Double.valueOf(vueGysphs1.get(i).getDefen5()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen6()) + Double.valueOf(vueGysphs1.get(i).getDefen6()) + Double.valueOf(vueGysphs1.get(i).getDefen7()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen8()) + Double.valueOf(vueGysphs1.get(i).getDefen9()) + Double.valueOf(vueGysphs1.get(i).getDefen8()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen9()) + Double.valueOf(vueGysphs1.get(i).getDefen10()) + Double.valueOf(vueGysphs1.get(i).getDefen11()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen12()) + Double.valueOf(vueGysphs1.get(i).getDefen13()) + Double.valueOf(vueGysphs1.get(i).getDefen14())
                    ));
                    break;
                case "2号高炉":
                    sh.put("gaolu2", vueGysphs1.get(i).getCsnamers());
                    sh.put("df2", df.format(Double.valueOf(vueGysphs1.get(i).getDefen1()) + Double.valueOf(vueGysphs1.get(i).getDefen2()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen3()) + Double.valueOf(vueGysphs1.get(i).getDefen4()) + Double.valueOf(vueGysphs1.get(i).getDefen5()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen6()) + Double.valueOf(vueGysphs1.get(i).getDefen6()) + Double.valueOf(vueGysphs1.get(i).getDefen7()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen8()) + Double.valueOf(vueGysphs1.get(i).getDefen9()) + Double.valueOf(vueGysphs1.get(i).getDefen8()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen9()) + Double.valueOf(vueGysphs1.get(i).getDefen10()) + Double.valueOf(vueGysphs1.get(i).getDefen11()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen12()) + Double.valueOf(vueGysphs1.get(i).getDefen13()) + Double.valueOf(vueGysphs1.get(i).getDefen14())
                    ));
                    break;
                case "3号高炉":
                    sh.put("gaolu3", vueGysphs1.get(i).getCsnamers());
                    sh.put("df3", df.format(Double.valueOf(vueGysphs1.get(i).getDefen1()) + Double.valueOf(vueGysphs1.get(i).getDefen2()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen3()) + Double.valueOf(vueGysphs1.get(i).getDefen4()) + Double.valueOf(vueGysphs1.get(i).getDefen5()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen6()) + Double.valueOf(vueGysphs1.get(i).getDefen6()) + Double.valueOf(vueGysphs1.get(i).getDefen7()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen8()) + Double.valueOf(vueGysphs1.get(i).getDefen9()) + Double.valueOf(vueGysphs1.get(i).getDefen8()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen9()) + Double.valueOf(vueGysphs1.get(i).getDefen10()) + Double.valueOf(vueGysphs1.get(i).getDefen11()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen12()) + Double.valueOf(vueGysphs1.get(i).getDefen13()) + Double.valueOf(vueGysphs1.get(i).getDefen14())
                    ));
                    break;
                case "4号高炉":
                    sh.put("gaolu4", vueGysphs1.get(i).getCsnamers());
                    sh.put("df4", df.format(Double.valueOf(vueGysphs1.get(i).getDefen1()) + Double.valueOf(vueGysphs1.get(i).getDefen2()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen3()) + Double.valueOf(vueGysphs1.get(i).getDefen4()) + Double.valueOf(vueGysphs1.get(i).getDefen5()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen6()) + Double.valueOf(vueGysphs1.get(i).getDefen6()) + Double.valueOf(vueGysphs1.get(i).getDefen7()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen8()) + Double.valueOf(vueGysphs1.get(i).getDefen9()) + Double.valueOf(vueGysphs1.get(i).getDefen8()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen9()) + Double.valueOf(vueGysphs1.get(i).getDefen10()) + Double.valueOf(vueGysphs1.get(i).getDefen11()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen12()) + Double.valueOf(vueGysphs1.get(i).getDefen13()) + Double.valueOf(vueGysphs1.get(i).getDefen14())
                    ));
                    break;
                case "5号高炉":
                    sh.put("gaolu5", vueGysphs1.get(i).getCsnamers());
                    sh.put("df5", df.format(Double.valueOf(vueGysphs1.get(i).getDefen1()) + Double.valueOf(vueGysphs1.get(i).getDefen2()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen3()) + Double.valueOf(vueGysphs1.get(i).getDefen4()) + Double.valueOf(vueGysphs1.get(i).getDefen5()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen6()) + Double.valueOf(vueGysphs1.get(i).getDefen6()) + Double.valueOf(vueGysphs1.get(i).getDefen7()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen8()) + Double.valueOf(vueGysphs1.get(i).getDefen9()) + Double.valueOf(vueGysphs1.get(i).getDefen8()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen9()) + Double.valueOf(vueGysphs1.get(i).getDefen10()) + Double.valueOf(vueGysphs1.get(i).getDefen11()) +
                            Double.valueOf(vueGysphs1.get(i).getDefen12()) + Double.valueOf(vueGysphs1.get(i).getDefen13()) + Double.valueOf(vueGysphs1.get(i).getDefen14())
                    ));
                    break;
                default:
                    break;
            }
        }
        return sh;
    }

    //顶层通铁量查询
    @RequestMapping("selectironnodata")
    public Map<String, String> selectironnodata() {
        List<Gltg> gltgs = gltgMapper.selectList(null);
        Gltg gltg = gltgs.get(gltgs.size() - 1);
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sf.format(date);
        HashMap<String, String> sh = new HashMap<>();
        DecimalFormat df = new DecimalFormat("0");
        String a[] = {"炼铁1#高炉", "炼铁2#高炉", "炼铁3#高炉", "炼铁4#高炉", "炼铁5#高炉"};
        String b[] = {gltg.getAddx(), gltg.getBdx(), gltg.getCdx(), gltg.getDdx(), gltg.getEdx()};
        String c[] = {"gl1", "gl2", "gl3", "gl4", "gl5"};
        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < b.length; i1++) {
                //Double selectiferis = selectiferis(b[i1], format, a[i]);
                i1 = i;
                String cuipjscls = cuipjscls(a[i], format, b[i1]);
                sh.put(c[i], cuipjscls);
                break;
            }
        }
        return sh;
    }

    private Double selectiferis(String ksrq, String format, String luhao) {
        QueryWrapper<Ironnodata> iqw = new QueryWrapper<>();
        iqw.between("rq", ksrq, format);
        iqw.eq("consign_unit", luhao);
        List<Ironnodata> ironnodata = ironnodataMapper.selectList(iqw);
        Double sueier = 0.0;
        for (int i = 0; i < ironnodata.size(); i++) {
            sueier = sueier + Double.valueOf(ironnodata.get(i).getPure()) / 1000;
        }
        return sueier;
    }

    //计划周期 最近两次
    @RequestMapping("selectmitemplanstartdate")
    public Object selectmitemplanstartdate() throws Exception {
        String a[] = {"1号高炉", "2号高炉", "3号高炉", "4号高炉", "5号高炉"};
        String b[] = {"gld1", "gld2", "gld3", "gld4", "gld5"};
        String c[] = {"glx1", "glx2", "glx3", "glx4", "glx5"};
        HashMap<String, String> shm = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            QueryWrapper<Item> iq = new QueryWrapper<>();
            iq.eq("process", a[i]);
            iq.between("planTime", 18, 30);
            iq.orderByAsc("planEndDate");
            List<Item> items = itemMapper.selectList(iq);
            String planenddate = items.get(items.size() - 1).getPlanenddate();
            String planenddate1 = items.get(items.size() - 2).getPlanenddate();
            String tegap = tegap(planenddate, planenddate1);
            shm.put(b[i], tegap);
            QueryWrapper<Item> iq1 = new QueryWrapper<>();
            iq1.eq("process", a[i]);
            iq1.eq("planTime", 9);
            iq1.orderByAsc("planEndDate");
            List<Item> items1 = itemMapper.selectList(iq1);
            if (!ObjectUtils.isEmpty(items1)) {
                String planenddate11 = items1.get(items1.size() - 1).getPlanenddate();
                String planenddate111 = items1.get(items1.size() - 2).getPlanenddate();
                String tegap1 = tegap(planenddate11, planenddate111);
                shm.put(c[i], tegap1);
            } else {
                shm.put(c[i], "0");
            }

        }
        return shm;
    }

    //运行监测标准
    @RequestMapping("selectbuzie")
    public List<Biaozhunyjjc> selectbuzie() {
        List<Biaozhunyjjc> biaozhunyjjcs = biaozhunyjjcMapper.selectList(null);
        return biaozhunyjjcs;
    }

    //运行监测修改
    @RequestMapping("upteajcbz")
    public List<Biaozhunyjjc> upteajcbz(String buzlist) {
        JSONArray jsonArray = JSONArray.parseArray(buzlist);
        for (int i = 0; i < jsonArray.size(); i++) {
            Biaozhunyjjc biaozhunyjjc = new Biaozhunyjjc();
            biaozhunyjjc.setShuzhi(jsonArray.getJSONObject(i).getString("shuzhi"));
            QueryWrapper<Biaozhunyjjc> bq = new QueryWrapper<>();
            bq.eq("id", jsonArray.getJSONObject(i).getString("id"));
            biaozhunyjjcMapper.update(biaozhunyjjc, bq);
        }
        List<Biaozhunyjjc> biaozhunyjjcs = biaozhunyjjcMapper.selectList(null);
        return biaozhunyjjcs;
    }

    //材料检验
    @RequestMapping("selectcljyame")
    public NavigableSet<String> selectcljyame() {
        List<VueglGl> vueglGls = vueglGlMapper.selectList(null);
        TreeSet<String> strings = new TreeSet<>();
        for (int i = 0; i < vueglGls.size(); i++) {
            if (vueglGls.get(i).getJieguopanding().equals("不合格")) {
                strings.add(vueglGls.get(i).getDhdate());
            }
        }
        NavigableSet<String> strings1 = strings.descendingSet();
        return strings1;
    }

    //施工管控
    @RequestMapping("selectsggkbzce")
    public ArrayList<VueglShigongguankong> selectsggkbzce() {
        QueryWrapper<VueglShigongguankong> vueglShigongguankongQueryWrapper = new QueryWrapper<>();
        vueglShigongguankongQueryWrapper.orderByDesc("rdate");
        List<VueglShigongguankong> vueglShigongguankongs = vueglShigongguankongMapper.selectList(vueglShigongguankongQueryWrapper);
        ArrayList<VueglShigongguankong> vueglShigongguankongs1 = new ArrayList<>();
        for (int i = 0; i < vueglShigongguankongs.size(); i++) {
            String ssjsrenyuan = vueglShigongguankongs.get(i).getSsjsrenyuan();
            String gaohugenzong = vueglShigongguankongs.get(i).getGaohugenzong();
            String shigongyichangjilu = vueglShigongguankongs.get(i).getShigongyichangjilu();
            if (!ObjectUtils.isEmpty(ssjsrenyuan) || !ObjectUtils.isEmpty(gaohugenzong) || !ssjsrenyuan.equals("-") || !gaohugenzong.equals("-")) {
                vueglShigongguankongs1.add(vueglShigongguankongs.get(i));
            }
        }
        return vueglShigongguankongs1;
    }

    //测温预警
    @RequestMapping("cewenyujingercs")
    public Object cewenyujingercs() {
        QueryWrapper<Temmie> temmieQueryWrapper = new QueryWrapper<>();
        temmieQueryWrapper.orderByDesc("riqidate");
        List<Temmie> temmies = temmieMapper.selectList(temmieQueryWrapper);
        ArrayList<Map<String, String>> maps = new ArrayList<>();
        for (int i = 0; i < temmies.size(); i++) {
            QueryWrapper<Biaozhunyjjc> bzqw = new QueryWrapper<>();
            bzqw.eq("weizhi", temmies.get(i).getWeizhi());
            bzqw.eq("luhao", temmies.get(i).getLuhao());
            List<Biaozhunyjjc> biaozhunyjjcs = biaozhunyjjcMapper.selectList(bzqw);
            if (Double.valueOf(temmies.get(i).getA0()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "a0");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getA0()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "a0");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getB1()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "b1");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getB1()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "b1");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getC2()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "c2");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getC2()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "c2");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getD3()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "d3");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getD3()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "d3");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getE4()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "e4");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getE4()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "e4");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getF5()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "f5");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getF5()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "f5");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getG6()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "g6");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getG6()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "g6");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getH7()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "h7");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getH7()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "h7");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getI8()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "i8");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getI8()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "i8");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getJ9()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "j9");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getJ9()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "j9");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getK10()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "k10");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getK10()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "k10");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getL11()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "l11");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getL11()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "l11");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getM12()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "m12");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getM12()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "m12");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getN13()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "n13");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getN13()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "n13");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getO14()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "o14");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getO14()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "o14");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getP15()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "p15");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getP15()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "p15");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getQ16()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "q16");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getQ16()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "q16");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getR17()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "r17");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getR17()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "r17");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getS18()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "s18");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getS18()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "s18");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getT19()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "t19");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getT19()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "t19");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getU20()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "u20");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getU20()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "u20");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getV21()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "v21");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getV21()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "v21");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getW22()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "w22");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getW22()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "w22");
                maps.add(sshm);
            }
            if (Double.valueOf(temmies.get(i).getX23()) >= Double.valueOf(biaozhunyjjcs.get(0).getShuzhi())) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "0");
                sshm.put("sex", "x23");
                maps.add(sshm);
            }
            if (Double.valueOf(biaozhunyjjcs.get(0).getShuzhi()) - Double.valueOf(temmies.get(i).getX23()) <= 50) {
                HashMap<String, String> sshm = new HashMap<>();
                sshm.put("riqidate", temmies.get(i).getRiqidate());
                sshm.put("itemes", "1");
                sshm.put("sex", "x23");
                maps.add(sshm);
            }
        }
        return maps;
    }

    //顶层通铁量周期预警开始日期
    @RequestMapping("selectdckaridat")
    public List<Gltg> selectdckaridat() {
        QueryWrapper<Gltg> gltgQueryWrapper = new QueryWrapper<>();
        gltgQueryWrapper.orderByDesc("gangodate");
        gltgQueryWrapper.last("limit 1");
        List<Gltg> gltgs = gltgMapper.selectList(gltgQueryWrapper);
        return gltgs;
    }

    //初始化查询最高通铁和平均通铁
    @RequestMapping("selectzgtthpjtt1")
    public Object selectzgtthpjtt1() {
        //大修小修的各个版本的日期
        List<Gltg> gltgs = gltgMapper.selectList(null);
        //用于累计平均数总和的数组
        Double b[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        for (int i = gltgs.size() - 1; i >= 0; i--) {
            if (i == 0) {
                break;
            }
            if (!gltgs.get(i).getAddx().equals(gltgs.get(i - 1).getAddx())) {
                String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAddx(), gltgs.get(i - 1).getAddx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[0]) {
                    b[0] = Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getAdxx().equals(gltgs.get(i - 1).getAdxx())) {
                String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAdxx(), gltgs.get(i - 1).getAdxx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[1]) {
                    b[1] = Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getAxdx().equals(gltgs.get(i - 1).getAxdx())) {
                String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAxdx(), gltgs.get(i - 1).getAxdx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[2]) {
                    b[2] = Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getAxxx().equals(gltgs.get(i - 1).getAxxx())) {
                String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAxxx(), gltgs.get(i - 1).getAxxx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[3]) {
                    b[3] = Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getBdx().equals(gltgs.get(i - 1).getBdx())) {
                String cuipjscls = cuipjscls("炼铁2#高炉", gltgs.get(i).getBdx(), gltgs.get(i - 1).getBdx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[4]) {
                    b[4] = Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getBxx().equals(gltgs.get(i - 1).getBxx())) {
                String cuipjscls = cuipjscls("炼铁2#高炉", gltgs.get(i).getBxx(), gltgs.get(i - 1).getBxx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[5]) {
                    b[5] = Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getCdx().equals(gltgs.get(i - 1).getCdx())) {
                String cuipjscls = cuipjscls("炼铁3#高炉", gltgs.get(i).getCdx(), gltgs.get(i - 1).getCdx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[6]) {
                    b[6] = Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getCxx().equals(gltgs.get(i - 1).getCxx())) {
                String cuipjscls = cuipjscls("炼铁3#高炉", gltgs.get(i).getCxx(), gltgs.get(i - 1).getCxx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[7]) {
                    b[7] = Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getDdx().equals(gltgs.get(i - 1).getDdx())) {
                String cuipjscls = cuipjscls("炼铁4#高炉", gltgs.get(i).getDdx(), gltgs.get(i - 1).getDdx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[8]) {
                    b[8] = Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getDxx().equals(gltgs.get(i - 1).getDxx())) {
                String cuipjscls = cuipjscls("炼铁4#高炉", gltgs.get(i).getDxx(), gltgs.get(i - 1).getDxx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[9]) {
                    b[9] = Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getEdx().equals(gltgs.get(i - 1).getEdx())) {
                String cuipjscls = cuipjscls("炼铁5#高炉", gltgs.get(i).getEdx(), gltgs.get(i - 1).getEdx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[10]) {
                    b[10] = Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getExx().equals(gltgs.get(i - 1).getExx())) {
                String cuipjscls = cuipjscls("炼铁5#高炉", gltgs.get(i).getExx(), gltgs.get(i - 1).getExx());
                if (!ObjectUtils.isEmpty(cuipjscls) && Double.valueOf(cuipjscls) > b[11]) {
                    b[11] = Double.valueOf(cuipjscls);
                }
            }
        }
        DecimalFormat df = new DecimalFormat("0");
        String c[] = new String[12];
        c[0] = df.format(b[0]);
        c[1] = df.format(b[1]);
        c[2] = df.format(b[2]);
        c[3] = df.format(b[3]);
        c[4] = df.format(b[4]);
        c[5] = df.format(b[5]);
        c[6] = df.format(b[6]);
        c[7] = df.format(b[7]);
        c[8] = df.format(b[8]);
        c[9] = df.format(b[9]);
        c[10] = df.format(b[10]);
        c[11] = df.format(b[11]);
        return c;
    }

    //大修小修平均通铁
    @RequestMapping("cegep")
    public Object cegep() {
        //大修小修的各个版本的日期
        List<Gltg> gltgs = gltgMapper.selectList(null);
        //用于累计平均数次数的数组
        int a[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        //用于累计平均数总和的数组
        Double b[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        for (int i = gltgs.size() - 1; i >= 0; i--) {
            if (i == 0) {
                break;
            }
            if (!gltgs.get(i).getAddx().equals(gltgs.get(i - 1).getAddx())) {
                String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAddx(), gltgs.get(i - 1).getAddx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[0]++;
                    b[0] = b[0] + Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getAdxx().equals(gltgs.get(i - 1).getAdxx())) {
                String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAdxx(), gltgs.get(i - 1).getAdxx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[1]++;
                    b[1] = b[1] + Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getAxdx().equals(gltgs.get(i - 1).getAxdx())) {
                String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAxdx(), gltgs.get(i - 1).getAxdx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[2]++;
                    b[2] = b[2] + Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getAxxx().equals(gltgs.get(i - 1).getAxxx())) {
                String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAxxx(), gltgs.get(i - 1).getAxxx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[3]++;
                    b[3] = b[3] + Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getBdx().equals(gltgs.get(i - 1).getBdx())) {
                String cuipjscls = cuipjscls("炼铁2#高炉", gltgs.get(i).getBdx(), gltgs.get(i - 1).getBdx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[4]++;
                    b[4] = b[4] + Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getBxx().equals(gltgs.get(i - 1).getBxx())) {
                String cuipjscls = cuipjscls("炼铁2#高炉", gltgs.get(i).getBxx(), gltgs.get(i - 1).getBxx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[5]++;
                    b[5] = b[5] + Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getCdx().equals(gltgs.get(i - 1).getCdx())) {
                String cuipjscls = cuipjscls("炼铁3#高炉", gltgs.get(i).getCdx(), gltgs.get(i - 1).getCdx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[6]++;
                    b[6] = b[6] + Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getCxx().equals(gltgs.get(i - 1).getCxx())) {
                String cuipjscls = cuipjscls("炼铁3#高炉", gltgs.get(i).getCxx(), gltgs.get(i - 1).getCxx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[7]++;
                    b[7] = b[7] + Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getDdx().equals(gltgs.get(i - 1).getDdx())) {
                String cuipjscls = cuipjscls("炼铁4#高炉", gltgs.get(i).getDdx(), gltgs.get(i - 1).getDdx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[8]++;
                    b[8] = b[8] + Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getDxx().equals(gltgs.get(i - 1).getDxx())) {
                String cuipjscls = cuipjscls("炼铁4#高炉", gltgs.get(i).getDxx(), gltgs.get(i - 1).getDxx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[9]++;
                    b[9] = b[9] + Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getEdx().equals(gltgs.get(i - 1).getEdx())) {
                String cuipjscls = cuipjscls("炼铁5#高炉", gltgs.get(i).getEdx(), gltgs.get(i - 1).getEdx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[10]++;
                    b[10] = b[10] + Double.valueOf(cuipjscls);
                }
            }
            if (!gltgs.get(i).getExx().equals(gltgs.get(i - 1).getExx())) {
                String cuipjscls = cuipjscls("炼铁5#高炉", gltgs.get(i).getExx(), gltgs.get(i - 1).getExx());
                if (!ObjectUtils.isEmpty(cuipjscls)) {
                    a[11]++;
                    b[11] = b[11] + Double.valueOf(cuipjscls);
                }
            }
        }
        DecimalFormat df = new DecimalFormat("0");
        String c[] = new String[12];
        c[0] = df.format(b[0] / a[0]);
        c[1] = df.format(b[1] / a[1]);
        c[2] = df.format(b[2] / a[2]);
        c[3] = df.format(b[3] / a[3]);
        c[4] = df.format(b[4] / a[4]);
        c[5] = df.format(b[5] / a[5]);
        c[6] = df.format(b[6] / a[6]);
        c[7] = df.format(b[7] / a[7]);
        c[8] = df.format(b[8] / a[8]);
        c[9] = df.format(b[9] / a[9]);
        c[10] = df.format(b[10] / a[10]);
        c[11] = df.format(b[11] / a[11]);
        return c;
    }

    private String cuipjscls(String luhao, String riqia, String riqib) {
        DecimalFormat df = new DecimalFormat("0");
        QueryWrapper<Ironnodata> iqw = new QueryWrapper<>();
        iqw.eq("consign_unit", luhao);
        iqw.between("rq", riqib, riqia);
        iqw.select("sum(pure) as pure");
        List<Map<String, Object>> maps = ironnodataMapper.selectMaps(iqw);
        String pure = "";
        if (!ObjectUtils.isEmpty(maps) && !ObjectUtils.isEmpty(maps.get(0))) {
            pure = df.format((Double) maps.get(0).get("pure") / 1000);
        }
        return pure;
    }

    //履历复盘日期区间和数据
    @RequestMapping("selectrijdhsj")
    public Object selectrijdhsj(String laiks, String nianfen) {
        ArrayList<Map<String, Object>> maps = new ArrayList<>();
        QueryWrapper<Gltg> gltgQueryWrapper = new QueryWrapper<>();
        gltgQueryWrapper.between("gangodate", nianfen + "-" + "01-01", nianfen + "-" + "12-31");
        List<Gltg> gltgs = gltgMapper.selectList(gltgQueryWrapper);
        for (int i = gltgs.size() - 1; i >= 0; i--) {
            if (i == 0) {
                break;
            }
            switch (laiks) {
                case "1#高炉(东)":
                    if (!gltgs.get(i).getAddx().equals(gltgs.get(i - 1).getAddx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAddx(), gltgs.get(i - 1).getAddx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getAddx().substring(5, 10));
                        strings.add(gltgs.get(i).getAddx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "大修");
                        maps.add(hashMap);
                    }
                    if (!gltgs.get(i).getAdxx().equals(gltgs.get(i - 1).getAdxx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAdxx(), gltgs.get(i - 1).getAdxx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getAdxx().substring(5, 10));
                        strings.add(gltgs.get(i).getAdxx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "小修");
                        maps.add(hashMap);
                    }
                    break;
                case "1#高炉(西)":
                    if (!gltgs.get(i).getAxdx().equals(gltgs.get(i - 1).getAxdx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAxdx(), gltgs.get(i - 1).getAxdx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getAxdx().substring(5, 10));
                        strings.add(gltgs.get(i).getAxdx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "大修");
                        maps.add(hashMap);
                    }
                    if (!gltgs.get(i).getAxxx().equals(gltgs.get(i - 1).getAxxx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁1#高炉", gltgs.get(i).getAxxx(), gltgs.get(i - 1).getAxxx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getAxxx().substring(5, 10));
                        strings.add(gltgs.get(i).getAxxx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "小修");
                        maps.add(hashMap);
                    }
                    break;
                case "2#高炉":
                    if (!gltgs.get(i).getBdx().equals(gltgs.get(i - 1).getBdx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁2#高炉", gltgs.get(i).getBdx(), gltgs.get(i - 1).getBdx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getBdx().substring(5, 10));
                        strings.add(gltgs.get(i).getBdx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "大修");
                        maps.add(hashMap);
                    }
                    if (!gltgs.get(i).getBxx().equals(gltgs.get(i - 1).getBxx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁2#高炉", gltgs.get(i).getBxx(), gltgs.get(i - 1).getBxx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getBxx().substring(5, 10));
                        strings.add(gltgs.get(i).getBxx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "小修");
                        maps.add(hashMap);
                    }
                    break;
                case "3#高炉":
                    if (!gltgs.get(i).getCdx().equals(gltgs.get(i - 1).getCdx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁3#高炉", gltgs.get(i).getCdx(), gltgs.get(i - 1).getCdx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getCdx().substring(5, 10));
                        strings.add(gltgs.get(i).getCdx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "大修");
                        maps.add(hashMap);
                    }
                    if (!gltgs.get(i).getCxx().equals(gltgs.get(i - 1).getCxx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁3#高炉", gltgs.get(i).getCxx(), gltgs.get(i - 1).getCxx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getCxx().substring(5, 10));
                        strings.add(gltgs.get(i).getCxx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "小修");
                        maps.add(hashMap);
                    }
                    break;
                case "4#高炉":
                    if (!gltgs.get(i).getDdx().equals(gltgs.get(i - 1).getDdx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁4#高炉", gltgs.get(i).getDdx(), gltgs.get(i - 1).getDdx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getDdx().substring(5, 10));
                        strings.add(gltgs.get(i).getDdx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "大修");
                        maps.add(hashMap);
                    }
                    if (!gltgs.get(i).getDxx().equals(gltgs.get(i - 1).getDxx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁4#高炉", gltgs.get(i).getDxx(), gltgs.get(i - 1).getDxx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getDxx().substring(5, 10));
                        strings.add(gltgs.get(i).getDxx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "小修");
                        maps.add(hashMap);
                    }
                    break;
                case "5#高炉":
                    if (!gltgs.get(i).getEdx().equals(gltgs.get(i - 1).getEdx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁5#高炉", gltgs.get(i).getEdx(), gltgs.get(i - 1).getEdx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getEdx().substring(5, 10));
                        strings.add(gltgs.get(i).getEdx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "大修");
                        maps.add(hashMap);
                    }
                    if (!gltgs.get(i).getExx().equals(gltgs.get(i - 1).getExx())) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String cuipjscls = cuipjscls("炼铁5#高炉", gltgs.get(i).getExx(), gltgs.get(i - 1).getExx());
                        hashMap.put("name", cuipjscls);
                        ArrayList<String> strings = new ArrayList<>();
                        strings.add("0");
                        strings.add(gltgs.get(i - 1).getExx().substring(5, 10));
                        strings.add(gltgs.get(i).getExx().substring(5, 10));
                        hashMap.put("value", strings);
                        hashMap.put("lx", "小修");
                        maps.add(hashMap);
                    }
                    break;
                default:
                    break;
            }
        }
        return maps;
    }

    //图片上传至本地

    @PostMapping(value = "/uploading")
    public @ResponseBody
    String uploadFile(@RequestPart("filename") MultipartFile file) throws Exception {
        System.out.println("接收到的文件数据为：" + file);
        if (file.isEmpty()) {
            return "上传文件为空";
        }
        // 获取文件全名a.py
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        // 文件上传路径<br>        String templatePath = "E:/file/template/"
        String templatePath = "D:/VUE/";
        System.out.println("文件路径:" + templatePath);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //获取文件名
        String prefixName = fileName.substring(0, fileName.lastIndexOf("."));
        // 解决中文问题,liunx 下中文路径,图片显示问题
        //fileName = UUID.randomUUID() + suffixName;
        File dest0 = new File(templatePath);
        File dest = new File(dest0, prefixName + File.separator + fileName);
        //文件上传-覆盖
        try {
            // 检测是否存在目录
            if (!dest0.getParentFile().exists()) {
                dest0.getParentFile().mkdirs();
                //检测文件是否存在
            }
            if (!dest.exists()) {
                dest.mkdirs();
            }
            file.transferTo(dest);
            return "上传成功";
        } catch (Exception e) {
            System.out.println("文件上传错误");
            return "上传失败";
        }
    }

    //图片上传至服务器
    public void sendPosts() {
        JSONObject jsonObject = new JSONObject();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("63df0072");
        jsonObject.put("id", strings);
        jsonObject.put("beginTime", "2022-04-24 00:00:01");
        jsonObject.put("endTime", "2022-04-24 11:59:59");
        jsonObject.put("limit", 3600);
        String s = jsonObject.toJSONString();
        HttpResponse execute = HttpRequest.post("http://e.ai:8083/data-governance/sensor/batch/sv/seconds/all").body(s).execute();
        JSONObject jsonObject1 = JSONObject.parseObject(execute.body());
        JSONArray jsonArray = JSONArray.parseArray(jsonObject1.getString("data"));
        JSONObject jsonObject2 = jsonArray.getJSONObject(0);
        JSONArray datas = jsonObject2.getJSONArray("datas");
        JSONObject jsonObject3 = datas.getJSONObject(0);
        //System.out.println(jsonObject3.getString("v"));
    }


    @RequestMapping("upeita")
    public void upeita() {
        List<Gltg> gltgs = gltgMapper.selectList(null);
        for (int i = 0; i < gltgs.size(); i++) {
            if (gltgs.get(i).getAdxx().equals("")) {
                QueryWrapper<Gltg> gltgQueryWrapper = new QueryWrapper<>();
                gltgQueryWrapper.eq("id", gltgs.get(i).getId());
                Gltg gltg = new Gltg();
                gltg.setAdxx("null");
                gltgMapper.update(gltg, gltgQueryWrapper);
            }
            if (gltgs.get(i).getAxxx().equals("")) {
                QueryWrapper<Gltg> gltgQueryWrapper = new QueryWrapper<>();
                gltgQueryWrapper.eq("id", gltgs.get(i).getId());
                Gltg gltg = new Gltg();
                gltg.setAxxx("null");
                gltgMapper.update(gltg, gltgQueryWrapper);
            }
            if (gltgs.get(i).getBxx().equals("")) {
                QueryWrapper<Gltg> gltgQueryWrapper = new QueryWrapper<>();
                gltgQueryWrapper.eq("id", gltgs.get(i).getId());
                Gltg gltg = new Gltg();
                gltg.setBxx("null");
                gltgMapper.update(gltg, gltgQueryWrapper);
            }
        }
    }

    @RequestMapping("ips")
    public void ips() {
        String a[] = {"1号高炉", "2号高炉", "3号高炉", "4号高炉", "5号高炉"};
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String format = sf.format(date);
        List<VueglGl> vueglGls = vueglGlMapper.selectList(null);
        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < vueglGls.size(); i1++) {
                VueglGl vueglGl = new VueglGl();
                vueglGl.setLhnubm(a[i]);
                vueglGl.setBbh(vueglGls.get(i).getBbh());
                vueglGl.setChangjia(vueglGls.get(i).getChangjia());
                vueglGl.setBianhao(vueglGls.get(i).getBianhao());
                vueglGl.setDhdate(vueglGls.get(i).getDhdate());
                vueglGl.setJianyanjieguo(vueglGls.get(i).getJianyanjieguo());
                vueglGl.setJieguopanding(vueglGls.get(i).getJieguopanding());
                vueglGl.setShiji(vueglGls.get(i).getShiji());
                vueglGl.setCunfangdidian(vueglGls.get(i).getCunfangdidian());
                vueglGlMapper.insert(vueglGl);
            }
        }
    }

    @RequestMapping("ies")
    public void ies() {
        String a[] = {"1号高炉", "2号高炉", "3号高炉", "4号高炉", "5号高炉"};
        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                VueglShigongguankong vueglShigongguankong = new VueglShigongguankong();
                vueglShigongguankong.setRdate("1");
                vueglShigongguankong.setBiaozhun("1");
                vueglShigongguankong.setYongshi("1");
                vueglShigongguankong.setCundangzhaopian("1");
                vueglShigongguankong.setGjsscc("1");
                vueglShigongguankong.setSsjsrenyuan("1");
                vueglShigongguankong.setGaohugenzong("1");
                vueglShigongguankong.setShigongyichangjilu("1");
                vueglShigongguankong.setLurudate("2022-06-14");
                vueglShigongguankong.setLuhao(a[i]);
                vueglShigongguankongMapper.insert(vueglShigongguankong);
            }
        }
    }
}
