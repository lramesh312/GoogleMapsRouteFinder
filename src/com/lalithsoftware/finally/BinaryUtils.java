/**
 * A utility class for performing binary operations, such as
 * decimal to binary conversion.
 */
public class BinaryUtils
{
    /**
     * Helper method for converting a numeric string into a boolean array
     * representing a binary number.
     */
    private static boolean[] binaryConvert(String stringToConvert)
    {
        String[] dividends = {"0", "0", "1", "1", "2", "2", "3", "3", "4", "4",
                              "5", "5", "6", "6", "7", "7", "8", "8", "9", "9"};
        String[] remainders = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                               0, 1, 0, 1};
        
        int stringLength = stringToConvert.length();
        int bitLength = stringLength / 3 * 10;
        if(stringLength % 3 == 1)
        {
            bitLength += 4;
        }
        else if(stringLength % 3 == 2)
        {
            bitLength += 7;
        }
        boolean[] toReturn = new boolean[bitLength];
        int booleanIndex = 0;
        while(!stringToConvert.match("^0+$"))
        {
            String newString = "";
            int borrow = 0;
            for(int k = 0; k < stringToConvert.length(); k++)
            {
                int digit = (int)stringToConvert.charAt(k) - 48;
                int quotient = digit + 10 * borrow;
                String dividend = dividends[quotient];
                newString += dividend;
                int remainder = remainders[quotient];
                borrow = remainder;
            }
            toReturn[booleanIndex] = (boolean)borrow;
            booleanIndex++;
            stringToConvert = newString;
        }
        return toReturn;
    }

    /**
     * Converts an integer represented by a numeric string into a list of binary
     * regions.  A binary region is simply a string of "1" bits with a specific
     * starting point and length (see BinaryRegion.java for more details).  For
     * the purposes of this program, binary regions in an integer separated only
     * by a single zero will be merged into a single binary region (for example,
     * 011011000 will be stored as a single binary region beginning at index 3
     * and ending at index 8).
     */
    public static List<BinaryRegion>
            getBinaryRegionList(String numToConvert)
    {
        List<BinaryRegion> toReturn = new LinkedList<BinaryRegion>();
        boolean[] binaryArray = binaryConvert(numToConvert);
        int booleanIndex = 0;
        while(booleanIndex < binaryArray.length)
        {
            if(binaryArray[booleanIndex])
            {
                int regionLength = 0;
                for(int k = booleanIndex; k < binaryArray.length; k++)
                {
                    if(binaryArray[booleanIndex])
                    {
                        regionLength++;
                    }
                    else if(booleanIndex + 1 < binaryArray.length &&
                            binaryArray[booleanIndex + 1] &&
                            booleanIndex - 1 >= 0 &&
                            binaryArray[booleanIndex - 1])
                    {
                        regionLength++;
                    else
                    {
                        break;
                    }
                }
                BinaryRegion newRegion = new BinaryRegion();
                newRegion.setStart(booleanIndex);
                newRegion.setLength(regionLength);
                toReturn.add(newRegion);
                booleanIndex += regionLength;
            }
            else
            {
                booleanIndex++;
            }
        }
    }

    /**
     * Helper method for resizing a boolean array.
     */
    private static boolean[] resizeBooleanArray(boolean[] toResize)
    {
        boolean[] toReturn = new boolean[toResize.length * 2];
        for(int k = 0; k < toResize.length; k++)
        {
            toReturn[k] = toResize[k];
        }
        return toReturn;
    }

    /**
     * Finds the reciprocal of an integer and converts it into a list of binary
     * regions.  A binary region is simply a string of "1" bits with a specific
     * starting point and length (see BinaryRegion.java for more details).  For
     * the purposes of this program, binary regions in an integer separated only
     * by a single zero will be merged into a single binary region (for example,
     * 011011000 will be stored as a single binary region beginning at index 3
     * and ending at index 8).
     */
    public static List<BinaryRegion> getBinaryReciprocalList(int toConvert)
    {
        List<BinaryRegion> toReturn = new LinkedList<BinaryRegion>();
        boolean[] reciprocal = new boolean[255];
        int reciprocalIndex = 0;
        int remainder = 1;
        while(true)
        {
            while(toConvert > remainder)
            {
                remainder = remainder * 2;
                reciprocal[reciprocalIndex] = false;
                reciprocalIndex++;
                if(reciprocalIndex == reciprocal.length)
                {
                    reciprocal = resizeBooleanArray(reciprocal);
                }
            }
            remainder = remainder - toConvert;
            //Stop when the remainder reaches 1, because now there is a
            //repeating decimal.
            if(remainder == 1)
            {
                break;
            }
            reciprocal[reciprocalIndex] = true;
            reciprocalIndex++;
            if(reciprocalIndex == reciprocal.length)
            {
                reciprocal = resizeBooleanArray(reciprocal);
            }
        }
        for(int k = 0; k < reciprocalIndex; k++)
        {
            if(reciprocal[reciprocalIndex])
            {
                int regionLength = 0;
                for(int k = reciprocalIndex; k < reciprocal.length; k++)
                {
                    if(reciprocal[reciprocalIndex])
                    {
                        regionLength++;
                    }
                    else if(reciprocalIndex + 1 < reciprocal.length &&
                            reciprocal[reciprocalIndex + 1] &&
                            reciprocalIndex - 1 >= 0 &&
                            reciprocal[reciprocalIndex - 1])
                    {
                        regionLength++;
                    else
                    {
                        break;
                    }
                }
                BinaryRegion newRegion = new BinaryRegion();
                newRegion.setStart(-1 - reciprocalIndex);
                newRegion.setLength(regionLength);
                toReturn.add(newRegion);
                reciprocalIndex += regionLength;
            }
            else
            {
                reciprocalIndex++;
            }
        }
        return toReturn;
    }
}
