package elucent.rootsclassic.ritual.rituals;

import java.util.List;
import elucent.rootsclassic.ritual.RitualBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RitualCauseRain extends RitualBase {

  public RitualCauseRain(String name, int level, double r, double g, double b) {
    super(name, level, r, g, b);
  }


  @Override
  public void doEffect(World world, BlockPos pos, List<ItemStack> inventory, List<ItemStack> incenses) {
    inventory.clear();
    world.getWorldInfo().setRaining(true);
  }

}
