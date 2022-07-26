package tceia.machineRepair8015.service.impl;

import tceia.machineRepair8015.entity.Item;
import tceia.machineRepair8015.mapper.ItemMapper;
import tceia.machineRepair8015.service.IItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lizhen
 * @since 2022-06-10
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

}
