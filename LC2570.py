# problem: 2570. Merge Two 2D Arrays by Summing Values
# difficulty: easy
# time: O(n)
# space: O(n)

class Solution:
    def mergeArrays(self, nums1: List[List[int]], nums2: List[List[int]]) -> List[List[int]]:
        n3 = []

        N1 = len(nums1)
        N2 = len(nums2)
        
        i,j = 0,0

        while i < N1 and j < N2:
            if nums1[i][0] < nums2[j][0]:
                n3.append(nums1[i])
                i += 1
            elif nums1[i][0] > nums2[j][0]:
                n3.append(nums2[j])
                j += 1
            else:
                n3.append([nums1[i][0], nums1[i][1]+nums2[j][1]])
                i += 1
                j += 1
        
        while i < N1:
            n3.append(nums1[i])
            i += 1
        while j < N2:
            n3.append(nums2[j])
            j += 1

        return n3
