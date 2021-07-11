package observable.client

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.gui.GuiComponent
import net.minecraft.client.gui.components.Button
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.TranslatableComponent
import kotlin.math.roundToInt

class ProfileScreen : Screen(TranslatableComponent("screen,observable.profile")) {
    var duration: Int = 30

    override fun init() {
        super.init()

        var startBtn = addButton(Button(
            0, height / 2 - 50, 100, 20, TranslatableComponent("text.observable.profile_tps")
        ) {  })

        startBtn.x = width / 2 - startBtn.width - 4

        var fpsBtn = addButton(Button(width / 2 + 4, height / 2 - 50, 100, 20, TranslatableComponent("text.observable.profile_fps")) { })

        var resultsBtn = addButton(Button(width / 2 + 4, height / 2 - 50, 100, 20, TranslatableComponent("text.observable.results")) { })
    }

    override fun render(poseStack: PoseStack, i: Int, j: Int, f: Float) {
        GuiComponent.drawCenteredString(poseStack, this.font, "Duration (scroll): $duration seconds", width / 2, height / 2 - 100, 0xFFFFFF)

        super.render(poseStack, i, j, f)
    }

    override fun keyPressed(i: Int, j: Int, k: Int): Boolean {
        return super.keyPressed(i, j, k)
    }

    override fun mouseScrolled(d: Double, e: Double, f: Double): Boolean {
//        Observable.LOGGER.info("$d, $e, $f")
        this.duration += f.roundToInt() * 5
        this.duration = this.duration.coerceIn(5, 60)
        return super.mouseScrolled(d, e, f)
    }
}