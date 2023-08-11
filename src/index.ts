import { registerPlugin } from '@capacitor/core';

import type { CameraVideoPlugin } from './definitions';

const CameraVideo = registerPlugin<CameraVideoPlugin>('CameraVideo', {
  web: () => import('./web').then(m => new m.CameraVideoWeb()),
});

export * from './definitions';
export { CameraVideo };
