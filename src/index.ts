import { registerPlugin } from '@capacitor/core';

import type { onVolumePressPlugin } from './definitions';

const onVolumePress = registerPlugin<onVolumePressPlugin>('onVolumePress', {
  web: () => import('./web').then(m => new m.onVolumePressWeb()),
});

export * from './definitions';
export { onVolumePress };
