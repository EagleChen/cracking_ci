triangle = [
  [193],
  [198, 132],
  [172, 166, 136],
  [188, 192, 138, 112],
  [178, 180, 183, 111, 150],
  [121, 130, 170, 119, 185, 102],
  [110, 155, 155, 172, 152, 114, 102],
  [184, 106, 123, 153, 131, 112, 107, 189],
  [125, 141, 142, 187, 113, 160, 195, 173, 107],
  [187, 178, 177, 119, 129, 152, 136, 159, 176, 126],
  [179, 159, 119, 172, 117, 175, 131, 155, 112, 104, 111],
  [113, 133, 175, 104, 125, 173, 194, 165, 180, 145, 176, 120]
]

path = Marshal.load(Marshal.dump(triangle))
sum  = Marshal.load(Marshal.dump(triangle))
path.each { |arr| arr.fill(0) }
sum.each { |arr| arr.fill(0) }
sum[sum.size-1] = triangle[sum.size-1]

(triangle.size-2).downto(0).each do |row|
  (0..row).each do |col|
    if sum[row+1][col] > sum[row+1][col+1]
      path[row][col] = 0
      sum[row][col] = triangle[row][col] + sum[row+1][col]
    else
      path[row][col] = 1
      sum[row][col] = triangle[row][col] + sum[row+1][col+1]
    end
  end
end

puts sum[0]
column = 0
(0..triangle.size-1).each do |row|
  print triangle[row][column]
  print " "
  column = path[row][column] + column
end
puts

