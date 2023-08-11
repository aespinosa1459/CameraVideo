import { WebPlugin } from '@capacitor/core';

import type { CameraVideoPlugin } from './definitions';

export class CameraVideoWeb extends WebPlugin implements CameraVideoPlugin {
  constructor() {
      super({
          name: 'CameraVideo',
          platforms: ['web']
      });
  }

  async openCamera(): Promise<{ imageUri: string }> {
      return { imageUri: 'web-camera-uri-placeholder' };
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
