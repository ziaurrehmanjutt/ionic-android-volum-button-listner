import Foundation

@objc public class onVolumePress: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
