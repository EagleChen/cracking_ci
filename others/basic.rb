require "rspec"

module BasicAlgorithms
  def bubble_sort(arr)
    return arr if simple?(arr)
    loop do
      has_swap = false
      (1..(arr.size-1)).each do |r|
        if arr[r-1] > arr[r]
          swap(arr, r, r-1)
          has_swap = true
        end
      end
      return arr unless has_swap
    end
  end

  def heap_sort(arr)
    return arr if simple?(arr)
    build_heap(arr)
    (arr.size-1).downto(1) do |swap_index|
      swap(arr, 0, swap_index)
      shift_down(arr, 0, swap_index-1)
    end
    arr
  end

  def merge_sort(arr)
    return arr if simple?(arr)
    merge_sort_internal(arr, 0, arr.size-1)
  end

  def quick_sort(arr)
    return arr if simple?(arr)
    partition(arr, 0, arr.size-1)
    arr
  end

  private

  def build_heap(arr)
    i = (arr.size - 2) / 2
    i.downto(0) { |index| shift_down(arr, index, arr.size-1) }
  end

  def shift_down(arr, index, bound)
    child = index * 2 + 1
    swap_index = index
    while child <= bound
      swap_index = child if arr[child] > arr[index]
      swap_index = child + 1 if child + 1 <= bound && arr[child+1] > arr[swap_index]
      return if swap_index == index
      swap(arr, index, swap_index)
      index = swap_index
      child = index * 2 + 1
    end
  end

  def swap(arr, index1, index2)
    arr[index1], arr[index2] = arr[index2], arr[index1]
  end

  def merge_sort_internal(arr, left, right)
    return arr.slice(left, 1) if left == right
    middle = (left + right) / 2
    arr1, arr2 = merge_sort_internal(arr, left, middle), merge_sort_internal(arr, middle+1, right)
    result = []
    l, r = 0, 0
    while l < arr1.size && r < arr2.size
      if arr1[l] < arr2[r]
        result << arr1[l]
        l = l + 1
      else
        result << arr2[r]
        r = r + 1
      end
    end
    result.concat(arr1[l..(arr1.size-1)]) if l < arr1.size
    result.concat(arr2[r..(arr2.size-1)]) if r < arr2.size
    result
  end

  def partition(arr, left, right)
    return if left >= right
    pivot = arr[left]
    lpos = left
    rpos = right
    while left < right
      while arr[left] <= pivot && left < right
        left = left + 1
      end
      while arr[right] > pivot && left <= right
        right = right - 1
      end
      arr[left], arr[right] = arr[right], arr[left] if left < right
    end
    arr[lpos], arr[right] = arr[right], pivot
    partition(arr, lpos, right-1)
    partition(arr, right+1, rpos)
  end

  def simple?(arr)
    arr.nil? || arr.empty? || (arr.size == 1)
  end

end

RSpec.configure do |config|
 config.include(BasicAlgorithms)
end

describe "BasicAlgorithms" do
  let(:unsorted) {
    [
      nil,
      [],
      [3, 2, 1, 3, 4, 7, 5],
      [3195, 4189, 2547, 8543, 1533, 5456, 4980, 1849,
       8041, 6036, 7067, 8579, 6590, 6739, 8293, 853, 5732, 8730, 7492, 2652,
       8207, 9959, 2027, 5756, 1927, 3286, 9304, 3001, 2565, 5737, 826, 1927,
       7924, 4521, 8105, 8195, 9879, 7951, 2774, 1362, 2970, 9007, 5191, 4109,
       5494, 8192, 7136, 5971, 3631, 4991, 6735, 9593, 9660, 2064, 4619, 6553,
       8229, 437, 5385, 5476, 7482, 6320, 6788, 6887, 9482, 9740, 7696, 4113,
       9902, 1229, 8704, 9150, 7396, 1611, 4369, 361, 1830, 5033, 1088, 4501,
       7430, 4119, 4767, 1844, 1484, 517, 6017, 5574, 2003, 8380, 6837, 494,
       3422, 1608, 9448, 1764, 2824, 9932, 2566, 4204]
    ]
  }

  let(:sorted) {
    [
      nil,
      [],
      [1, 2, 3, 3, 4, 5, 7],
      [361, 437, 494, 517, 826, 853, 1088, 1229, 1362, 1484,
       1533, 1608, 1611, 1764, 1830, 1844, 1849, 1927, 1927, 2003, 2027, 2064,
       2547, 2565, 2566, 2652, 2774, 2824, 2970, 3001, 3195, 3286, 3422, 3631,
       4109, 4113, 4119, 4189, 4204, 4369, 4501, 4521, 4619, 4767, 4980, 4991,
       5033, 5191, 5385, 5456, 5476, 5494, 5574, 5732, 5737, 5756, 5971, 6017,
       6036, 6320, 6553, 6590, 6735, 6739, 6788, 6837, 6887, 7067, 7136, 7396,
       7430, 7482, 7492, 7696, 7924, 7951, 8041, 8105, 8192, 8195, 8207, 8229,
       8293, 8380, 8543, 8579, 8704, 8730, 9007, 9150, 9304, 9448, 9482, 9593,
       9660, 9740, 9879, 9902, 9932, 9959]
    ]
  }

  it "supports sort algorithms" do
    [:quick_sort, :merge_sort, :heap_sort, :bubble_sort].each do |algorithm|
      unsorted.zip(sorted).each do |input, output|
        input = input.dup if input
        method(algorithm).call(input).should eq output
      end
    end
  end

end
