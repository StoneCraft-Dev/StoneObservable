package observable.forge

import net.minecraftforge.client.event.RenderWorldLastEvent
import net.minecraftforge.eventbus.api.SubscribeEvent

object ForgeClientHooks {
    @SubscribeEvent
    fun onRender(ev: RenderWorldLastEvent) {
    }
}