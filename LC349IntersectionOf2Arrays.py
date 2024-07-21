// 1.
// runtime: 43ms, beats 85.95%
// memory: 16.71MB, beats 20.92%
// Problem: 349. Intersection of Two Arrays

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        s1 = set(nums1)
        s2 = set(nums2)
        return list(s1 & s2)


// 2.
// runtime: 50ms, beats 44.06%
// memory: 16.80MB, beats 20.92%
// Problem: 349. Intersection of Two Arrays
class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        d = Counter(set(nums1)) & Counter(set(nums2))
        return d.elements()
