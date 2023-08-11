export interface CameraVideoPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
