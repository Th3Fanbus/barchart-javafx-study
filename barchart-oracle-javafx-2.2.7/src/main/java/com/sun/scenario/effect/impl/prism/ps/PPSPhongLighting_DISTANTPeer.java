/*     */ package com.sun.scenario.effect.impl.prism.ps;
/*     */ 
/*     */ import com.sun.javafx.geom.Rectangle;
/*     */ import com.sun.prism.ps.Shader;
/*     */ import com.sun.scenario.effect.Color4f;
/*     */ import com.sun.scenario.effect.FilterContext;
/*     */ import com.sun.scenario.effect.PhongLighting;
/*     */ import com.sun.scenario.effect.impl.BufferUtil;
/*     */ import com.sun.scenario.effect.impl.Renderer;
/*     */ import com.sun.scenario.effect.light.Light;
/*     */ import com.sun.scenario.effect.light.PointLight;
/*     */ import com.sun.scenario.effect.light.SpotLight;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class PPSPhongLighting_DISTANTPeer extends PPSTwoSamplerPeer
/*     */ {
/*     */   private FloatBuffer kvals;
/*     */ 
/*     */   public PPSPhongLighting_DISTANTPeer(FilterContext paramFilterContext, Renderer paramRenderer, String paramString)
/*     */   {
/*  45 */     super(paramFilterContext, paramRenderer, paramString);
/*     */   }
/*     */ 
/*     */   protected final PhongLighting getEffect()
/*     */   {
/*  50 */     return (PhongLighting)super.getEffect();
/*     */   }
/*     */ 
/*     */   private float getSurfaceScale()
/*     */   {
/*  57 */     return getEffect().getSurfaceScale();
/*     */   }
/*     */ 
/*     */   private float getDiffuseConstant() {
/*  61 */     return getEffect().getDiffuseConstant();
/*     */   }
/*     */ 
/*     */   private float getSpecularConstant() {
/*  65 */     return getEffect().getSpecularConstant();
/*     */   }
/*     */ 
/*     */   private float getSpecularExponent() {
/*  69 */     return getEffect().getSpecularExponent();
/*     */   }
/*     */ 
/*     */   private float[] getNormalizedLightPosition() {
/*  73 */     return getEffect().getLight().getNormalizedLightPosition();
/*     */   }
/*     */ 
/*     */   private float[] getLightPosition() {
/*  77 */     PointLight localPointLight = (PointLight)getEffect().getLight();
/*     */ 
/*  79 */     return new float[] { localPointLight.getX(), localPointLight.getY(), localPointLight.getZ() };
/*     */   }
/*     */ 
/*     */   private float[] getLightColor() {
/*  83 */     return getEffect().getLight().getColor().getPremultipliedRGBComponents();
/*     */   }
/*     */ 
/*     */   private float getLightSpecularExponent() {
/*  87 */     return ((SpotLight)getEffect().getLight()).getSpecularExponent();
/*     */   }
/*     */ 
/*     */   private float[] getNormalizedLightDirection() {
/*  91 */     return ((SpotLight)getEffect().getLight()).getNormalizedLightDirection();
/*     */   }
/*     */ 
/*     */   private FloatBuffer getKvals() {
/*  95 */     Rectangle localRectangle = getInputNativeBounds(0);
/*  96 */     float f1 = 1.0F / localRectangle.width;
/*  97 */     float f2 = 1.0F / localRectangle.height;
/*     */ 
/*  99 */     float[] arrayOfFloat1 = { -1.0F, 0.0F, 1.0F, -2.0F, 0.0F, 2.0F, -1.0F, 0.0F, 1.0F };
/*     */ 
/* 104 */     float[] arrayOfFloat2 = { -1.0F, -2.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F };
/*     */ 
/* 109 */     if (this.kvals == null) {
/* 110 */       this.kvals = BufferUtil.newFloatBuffer(32);
/*     */     }
/* 112 */     this.kvals.clear();
/* 113 */     int i = 0;
/* 114 */     float f3 = -getSurfaceScale() * 0.25F;
/* 115 */     for (int j = -1; j <= 1; j++) {
/* 116 */       for (int k = -1; k <= 1; k++) {
/* 117 */         if ((j != 0) || (k != 0)) {
/* 118 */           this.kvals.put(k * f1);
/* 119 */           this.kvals.put(j * f2);
/* 120 */           this.kvals.put(arrayOfFloat1[i] * f3);
/* 121 */           this.kvals.put(arrayOfFloat2[i] * f3);
/*     */         }
/* 123 */         i++;
/*     */       }
/*     */     }
/* 126 */     this.kvals.rewind();
/* 127 */     return this.kvals;
/*     */   }
/*     */ 
/*     */   private int getKvalsArrayLength() {
/* 131 */     return 8;
/*     */   }
/*     */ 
/*     */   protected boolean isSamplerLinear(int paramInt)
/*     */   {
/* 137 */     switch (paramInt) {
/*     */     }
/* 139 */     return false;
/*     */   }
/*     */ 
/*     */   protected Shader createShader()
/*     */   {
/* 145 */     HashMap localHashMap1 = new HashMap();
/* 146 */     localHashMap1.put("bumpImg", Integer.valueOf(0));
/* 147 */     localHashMap1.put("origImg", Integer.valueOf(1));
/*     */ 
/* 149 */     HashMap localHashMap2 = new HashMap();
/* 150 */     localHashMap2.put("normalizedLightPosition", Integer.valueOf(12));
/* 151 */     localHashMap2.put("diffuseConstant", Integer.valueOf(0));
/* 152 */     localHashMap2.put("lightColor", Integer.valueOf(3));
/* 153 */     localHashMap2.put("kvals", Integer.valueOf(4));
/* 154 */     localHashMap2.put("specularConstant", Integer.valueOf(1));
/* 155 */     localHashMap2.put("specularExponent", Integer.valueOf(2));
/*     */ 
/* 157 */     return getRenderer().createShader(getShaderName(), localHashMap1, localHashMap2, false);
/*     */   }
/*     */ 
/*     */   protected void updateShader(Shader paramShader)
/*     */   {
/* 163 */     float[] arrayOfFloat1 = getNormalizedLightPosition();
/* 164 */     paramShader.setConstant("normalizedLightPosition", arrayOfFloat1[0], arrayOfFloat1[1], arrayOfFloat1[2]);
/* 165 */     paramShader.setConstant("diffuseConstant", getDiffuseConstant());
/* 166 */     float[] arrayOfFloat2 = getLightColor();
/* 167 */     paramShader.setConstant("lightColor", arrayOfFloat2[0], arrayOfFloat2[1], arrayOfFloat2[2]);
/* 168 */     paramShader.setConstants("kvals", getKvals(), 0, getKvalsArrayLength());
/* 169 */     paramShader.setConstant("specularConstant", getSpecularConstant());
/* 170 */     paramShader.setConstant("specularExponent", getSpecularExponent());
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jfxrt/jfxrt.jar
 * Qualified Name:     com.sun.scenario.effect.impl.prism.ps.PPSPhongLighting_DISTANTPeer
 * JD-Core Version:    0.6.2
 */