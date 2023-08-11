export interface CameraVideoPlugin {
  openCamera(): Promise<{ imageUri: string }>;
}
