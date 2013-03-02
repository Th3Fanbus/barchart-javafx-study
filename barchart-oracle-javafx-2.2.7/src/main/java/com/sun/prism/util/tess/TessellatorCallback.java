package com.sun.prism.util.tess;

public abstract interface TessellatorCallback
{
  public abstract void begin(int paramInt);

  public abstract void beginData(int paramInt, Object paramObject);

  public abstract void edgeFlag(boolean paramBoolean);

  public abstract void edgeFlagData(boolean paramBoolean, Object paramObject);

  public abstract void vertex(Object paramObject);

  public abstract void vertexData(Object paramObject1, Object paramObject2);

  public abstract void end();

  public abstract void endData(Object paramObject);

  public abstract void combine(double[] paramArrayOfDouble, Object[] paramArrayOfObject1, float[] paramArrayOfFloat, Object[] paramArrayOfObject2);

  public abstract void combineData(double[] paramArrayOfDouble, Object[] paramArrayOfObject1, float[] paramArrayOfFloat, Object[] paramArrayOfObject2, Object paramObject);

  public abstract void error(int paramInt);

  public abstract void errorData(int paramInt, Object paramObject);
}

/* Location:           /home/user1/Temp/jfxrt/jfxrt.jar
 * Qualified Name:     com.sun.prism.util.tess.TessellatorCallback
 * JD-Core Version:    0.6.2
 */