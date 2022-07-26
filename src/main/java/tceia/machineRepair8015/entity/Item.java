package tceia.machineRepair8015.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lizhen
 * @since 2022-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String factory;

    @TableField("factoryCode")
    private String factorycode;

    private String process;

    @TableField("processCode")
    private String processcode;

    @TableField("repairClass")
    private String repairclass;

    @TableField("planStartDate")
    private String planstartdate;

    @TableField("planEndDate")
    private String planenddate;

    @TableField("planTime")
    private String plantime;

    @TableField("planUserNo")
    private String planuserno;

    @TableField("planUserName")
    private String planusername;

    @TableField("planEnterTime")
    private String planentertime;

    @TableField("repairContent")
    private String repaircontent;

    @TableField("standardTime")
    private String standardtime;

    @TableField("actualStartDate")
    private String actualstartdate;

    @TableField("actualEndDate")
    private String actualenddate;

    @TableField("actualTime")
    private String actualtime;

    @TableField("actualUserNo")
    private String actualuserno;

    @TableField("actualUserName")
    private String actualusername;

    @TableField("actualEnterTime")
    private String actualentertime;

    private String state;

    @TableField("fileUrl")
    private String fileurl;

    @TableField("fileName")
    private String filename;

    @TableField("repairMonth")
    private String repairmonth;

    @TableField("planState")
    private String planstate;

    @TableField("questClass")
    private String questclass;

    @TableField("questAnnexName")
    private String questannexname;

    @TableField("questAnnexUrl")
    private String questannexurl;

    @TableField("questAnnexDiscript")
    private String questannexdiscript;


}
