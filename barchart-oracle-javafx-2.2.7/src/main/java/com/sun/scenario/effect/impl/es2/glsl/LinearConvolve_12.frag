#ifdef GL_ES
#extension GL_OES_standard_derivatives : enable
precision highp float;
precision highp int;
#define HIGHP highp
#define MEDIUMP mediump
#define LOWP lowp
#else
#define HIGHP
#define MEDIUMP
#define LOWP
#endif
varying vec2 texCoord0;
uniform sampler2D img;
uniform int count;
uniform vec4 offset;
uniform vec4 weights[3];
void main() {
int i;
vec4 tmp = vec4(0.0, 0.0, 0.0, 0.0);
vec2 loc = texCoord0 + offset.zw;
{
tmp += weights[0].x * texture2D(img, loc);
loc += offset.xy;
tmp += weights[0].y * texture2D(img, loc);
loc += offset.xy;
tmp += weights[0].z * texture2D(img, loc);
loc += offset.xy;
tmp += weights[0].w * texture2D(img, loc);
loc += offset.xy;
}
{
tmp += weights[1].x * texture2D(img, loc);
loc += offset.xy;
tmp += weights[1].y * texture2D(img, loc);
loc += offset.xy;
tmp += weights[1].z * texture2D(img, loc);
loc += offset.xy;
tmp += weights[1].w * texture2D(img, loc);
loc += offset.xy;
}
{
tmp += weights[2].x * texture2D(img, loc);
loc += offset.xy;
tmp += weights[2].y * texture2D(img, loc);
loc += offset.xy;
tmp += weights[2].z * texture2D(img, loc);
loc += offset.xy;
tmp += weights[2].w * texture2D(img, loc);
loc += offset.xy;
}
gl_FragColor = tmp;
}
