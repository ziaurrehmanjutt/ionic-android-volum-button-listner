
import type { onVolumePressPlugin } from './definitions';
import type { ListenerCallback, PluginListenerHandle } from '@capacitor/core';
import { WebPlugin, Capacitor } from '@capacitor/core';

export class onVolumePressWeb extends WebPlugin implements onVolumePressPlugin {
  private platform = Capacitor.getPlatform();
  addListener(
    eventName: string,
    listenerFunc: ListenerCallback,
  ): Promise<PluginListenerHandle> & PluginListenerHandle {
    if (this.platform === 'ios') {
      return super.addListener(eventName, listenerFunc);
    } else if (this.platform === 'android') {
      return super.addListener(eventName, listenerFunc);
    } else {
      console.log('CapacitorVolumeButtons is not supported on web');
      return super.addListener(eventName, listenerFunc);
    }
  }
}
