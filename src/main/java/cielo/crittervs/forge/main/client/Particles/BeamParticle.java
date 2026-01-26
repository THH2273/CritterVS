package cielo.crittervs.forge.main.client.Particles;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BeamParticle extends TextureSheetParticle {
    private final float baseSize;

    protected BeamParticle(ClientLevel level, double x, double y, double z,
                           double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);

        // xSpeed contains the scale value, ySpeed and zSpeed are unused (always 0)
        double scale = xSpeed > 0 ? xSpeed : 1.0;

        this.xd = 0;
        this.yd = 0;
        this.zd = 0;

        this.baseSize = (float) (0.2F * scale);
        this.quadSize = this.baseSize;
        this.lifetime = 20;

        this.rCol = 0.3F;
        this.gCol = 0.8F;
        this.bCol = 1.0F;

        this.hasPhysics = false;
        this.setAlpha(0.8F);
    }

    @Override
    public void tick() {
        super.tick();

        // Fade out and shrink as the particle ages
        float ageRatio = (float) this.age / (float) this.lifetime;
        this.alpha = 0.8F * (1.0F - ageRatio);
        this.quadSize = this.baseSize * (1.0F - ageRatio);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return BEAMRENDERTYPE;
    }

    @Override
    protected int getLightColor(float partialTick) {
        return 255;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            BeamParticle particle = new BeamParticle(level, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.pickSprite(this.sprites);
            return particle;
        }
    }


    public static final ParticleRenderType BEAMRENDERTYPE = new ParticleRenderType(){

        @Override
        public void begin(BufferBuilder arg, TextureManager arg2) {
            RenderSystem.depthMask(true);
            RenderSystem.setShaderTexture(0, TextureAtlas.LOCATION_PARTICLES);
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
            arg.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.PARTICLE);
        }

        @Override
        public void end(Tesselator arg) {
            arg.end();
        }

        public String toString() {
            return "PARTICLE_SHEET_TRANSLUCENT";
        }
    };
}
